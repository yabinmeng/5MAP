package com.example;

import com.example.auto_gen.IotSensorKey;
import com.example.auto_gen.IotSensorVal;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.pulsar.client.api.*;
import org.apache.pulsar.client.impl.schema.AvroSchema;
import org.apache.pulsar.common.schema.KeyValue;
import org.apache.pulsar.common.schema.KeyValueEncodingType;

public class AvroSchemaProducer {

    public AvroSchemaProducer() {
    }

    private static void prdMsgWithAvroKey(PulsarClient pulsarClient, String topicName) {
        // for the fist topic
        Schema<KeyValue<IotSensorKey, IotSensorVal>> iotSensorSchemaP = Schema.KeyValue(
                //Schema.AVRO(IotSensorKey.class),
                AvroSchema.of(IotSensorKey.class),
                //Schema.AVRO(IotSensorVal.class),
                AvroSchema.of(IotSensorVal.class),
                KeyValueEncodingType.SEPARATED
        );

        try {
            Producer<KeyValue<IotSensorKey, IotSensorVal>> producer = pulsarClient.newProducer(iotSensorSchemaP)
                    .topic(topicName)
                    .create();

            for (int i = 0; i < 20; i++) {
                int siteId = RandomUtils.nextInt(0, AvroSchemaUtil.MAX_SENSOR_SITE_CNT);
                int stationId = RandomUtils.nextInt(0, AvroSchemaUtil.MAX_SENSOR_STATION_CNT);
                IotSensorKey iotSensorKey = new IotSensorKey(siteId, stationId);

                int sensorId = RandomUtils.nextInt(0, AvroSchemaUtil.MAX_SENSOR_CNT);
                String sensorType = AvroSchemaUtil.AVAILABLE_SENSOR_TYPES[RandomUtils.nextInt(0, AvroSchemaUtil.AVAILABLE_SENSOR_TYPES.length)];
                IotSensorVal iotSensorVal = new IotSensorVal("sensor-id-" + sensorId, sensorType, Integer.valueOf((int) System.currentTimeMillis()), RandomUtils.nextFloat());

                KeyValue<IotSensorKey, IotSensorVal> iotSensorData = new KeyValue<>(iotSensorKey, iotSensorVal);

                producer.newMessage()
                        .property("prop_1", String.valueOf(RandomStringUtils.randomAlphabetic(5, 10)))
                        .value(iotSensorData).send();
            }

            if (producer != null)
                producer.close();
        }
        catch (PulsarClientException pce) {
            pce.printStackTrace();
        }
    }

    private static void prdMsgWithStrKey(PulsarClient pulsarClient, String topicName) {
        // for the second topic
        AvroSchema<IotSensorVal> iotSensorSchemaP = AvroSchema.of(IotSensorVal.class);

        try {
            Producer<IotSensorVal> producer = pulsarClient.newProducer(iotSensorSchemaP)
                    .topic(topicName)
                    .create();

            for (int i = 0; i < 20; i++) {
                int siteId = RandomUtils.nextInt(0, AvroSchemaUtil.MAX_SENSOR_SITE_CNT);
                int stationId = RandomUtils.nextInt(0, AvroSchemaUtil.MAX_SENSOR_STATION_CNT);
                IotSensorKey iotSensorKey = new IotSensorKey(siteId, stationId);

                int sensorId = RandomUtils.nextInt(0, AvroSchemaUtil.MAX_SENSOR_CNT);
                String sensorType = AvroSchemaUtil.AVAILABLE_SENSOR_TYPES[RandomUtils.nextInt(0, AvroSchemaUtil.AVAILABLE_SENSOR_TYPES.length)];
                IotSensorVal iotSensorVal = new IotSensorVal("sensor-id-" + sensorId, sensorType, Integer.valueOf((int) System.currentTimeMillis()), RandomUtils.nextFloat());

                producer.newMessage()
                        .property("prop_2", String.valueOf(RandomStringUtils.randomAlphabetic(5, 10)))
                        .key("site-" + siteId + "|station-" + stationId).value(iotSensorVal).send();
            }

            if (producer != null)
                producer.close();
        }
        catch (PulsarClientException pce) {
            pce.printStackTrace();
        }
    }

    public static void main(String[] args) throws PulsarClientException {
        PulsarClient pulsarClient = PulsarClient.builder()
                .serviceUrl(AvroSchemaUtil.PULSAR_SVC_URL)
                .build();

        prdMsgWithAvroKey(pulsarClient, AvroSchemaUtil.TOPIC1);
        prdMsgWithStrKey(pulsarClient, AvroSchemaUtil.TOPIC2);

        if (pulsarClient != null)
            pulsarClient.close();

        System.exit(0);
    }
}
