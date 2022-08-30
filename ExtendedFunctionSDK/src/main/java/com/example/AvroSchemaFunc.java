package com.example;

import com.datastax.oss.driver.api.core.CqlSession;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.*;
import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.insertInto;

import com.datastax.oss.driver.api.core.cql.*;
import com.datastax.oss.driver.api.querybuilder.BuildableQuery;
import com.datastax.oss.driver.api.querybuilder.Literal;
import com.datastax.oss.driver.api.querybuilder.insert.InsertInto;
import com.datastax.oss.driver.api.querybuilder.insert.RegularInsert;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.pulsar.client.api.schema.Field;
import org.apache.pulsar.client.api.schema.GenericObject;
import org.apache.pulsar.client.api.schema.GenericRecord;
import org.apache.pulsar.common.schema.KeyValue;
import org.apache.pulsar.functions.api.Context;
import org.apache.pulsar.functions.api.Function;
import org.slf4j.Logger;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class AvroSchemaFunc implements Function<GenericObject, Void> {
    private Logger logger;

    // connection to C* cluster
    CqlSession cqlSession;
    BuildableQuery insertIntoIotSensorQuery;

    @Override
    public void initialize(Context context) {
        logger = context.getLogger();

        try {
            Map<String, Object> userConfigMap = context.getUserConfigMap();
            logger.info(">>>> User config map:" + userConfigMap);

            // C* contact point server host ip (default localhost)
            String cassSrvHost = "localhost";
            if (userConfigMap.containsKey("cass_host")) {
                cassSrvHost = (String) userConfigMap.get("cass_host");
            }

            // C* contact point server host port (default 9042)
            int cassSrvPort = 9042;
            if (userConfigMap.containsKey("cass_port")) {
                cassSrvPort = NumberUtils.toInt((String) userConfigMap.get("cass_port"), 9042);
            }

            cqlSession = CqlSession.builder()
                    .addContactPoint(new InetSocketAddress(cassSrvHost, cassSrvPort))
                    .withLocalDatacenter("Cassandra")
                    .build();

            logger.info(">>>> Connection to C* cluster has been established!" + cqlSession);
        }
        catch (Exception e) {
            logger.info("#### " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Void process(GenericObject genericObject, Context context) {
        try {
            //Map<String, String> msgProperties = context.getCurrentRecord().getProperties();
            Object object = genericObject.getNativeObject();

            KeyValue<GenericRecord, GenericRecord>
                    msgKeyValueData = (KeyValue<GenericRecord, GenericRecord>) object;

            // Pulsar Generic record
            GenericRecord msgKeyRecord = msgKeyValueData.getKey();
            GenericRecord msgValRecord = msgKeyValueData.getValue();

            if (insertIntoIotSensorQuery == null) {

                // Construct the "buildable" query dynamically based on
                // the message key and value schemas

                ArrayList<String> cassFiledNameList = new ArrayList();
                for (Field f : msgKeyRecord.getFields()) {
                    cassFiledNameList.add(StringUtils.lowerCase(f.getName()));
                }
                for (Field f : msgValRecord.getFields()) {
                    cassFiledNameList.add(StringUtils.lowerCase(f.getName()));
                }

                RegularInsert regularInsert = null;
                InsertInto insertInto = insertInto("testks", "iot_sensor");
                for (String cassFieldName : cassFiledNameList) {
                    regularInsert =
                            Objects.requireNonNullElse(regularInsert, insertInto).value(cassFieldName, bindMarker());
                }

                insertIntoIotSensorQuery = regularInsert;
            }


            // TBD:
            // 1) convert from Pulsar Generic record to a POJO, or
            // 2) convert from Avro Generic record to a POJO

            // native Avro Generic record
            //GenericData.Record msgKeyNativeRec = (GenericData.Record) msgKeyRecord.getNativeObject();
            //GenericData.Record msgValdNativeRec = (GenericData.Record) msgValRecord.getNativeObject();

            assert (insertIntoIotSensorQuery != null);
            logger.info(">>>> insertIntoIotSensorQuery: " + insertIntoIotSensorQuery.asCql());

            SimpleStatementBuilder stmtBuilder = insertIntoIotSensorQuery.builder();

            // Insert all fields from the message key
            logger.info("  >> Insert message with key: " + msgKeyRecord.getNativeObject() + "; " +
                    "and payload: " + msgValRecord.getNativeObject());
            for (Field kf : msgKeyRecord.getFields()) {
                stmtBuilder.addNamedValue(StringUtils.lowerCase(kf.getName()), msgKeyRecord.getField(kf).toString());
            }

            // Insert all fields from the message value
            for (Field vf : msgValRecord.getFields()) {
                stmtBuilder.addNamedValue(StringUtils.lowerCase(vf.getName()), msgValRecord.getField(vf).toString());
            }

            SimpleStatement stmt = stmtBuilder.build();
            ResultSet insertRs = cqlSession.execute(stmt);
        }
        catch (Exception e) {
            logger.info("#### " + e);
            throw new RuntimeException(e);
        }

        return  null;
    }

    @Override
    public void close() {
        if (cqlSession != null)
            cqlSession.close();
    }
}
