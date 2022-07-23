package com.example;

import com.example.auto_gen.IotSensorVal;
import org.apache.pulsar.client.api.*;
import org.apache.pulsar.client.api.schema.Field;
import org.apache.pulsar.client.api.schema.GenericRecord;
import org.apache.pulsar.client.impl.schema.AvroSchema;
import org.apache.pulsar.common.schema.KeyValue;
import org.apache.pulsar.common.schema.KeyValueEncodingType;

import java.util.List;

public class AvroSchemaConsumer {

    public AvroSchemaConsumer() {
    }

    public static String printGenericRecord(GenericRecord genericRecord) {
        assert (genericRecord != null);

        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        List<Field> fields = genericRecord.getFields();

        for (int i = 0; i < fields.size(); i++) {
            Field field = fields.get(i);
            sb.append(field.getName()).append("=");
            sb.append(genericRecord.getField(field));
            if (i < (fields.size() - 1)) {
                sb.append(", ");
            }
        }

        sb.append(" }");

        return sb.toString();
    }

    private static void recvMsgWithAvroKey(PulsarClient pulsarClient, String topicName) {
        // receive message from topic 1
        System.out.println("\nReceiving messages from topic: " + topicName);
        System.out.println("----------------------------------------");

        Schema<KeyValue<GenericRecord, GenericRecord>> iotSensorSchemaC = Schema.KeyValue(
                Schema.AUTO_CONSUME(),
                Schema.AUTO_CONSUME(),
                KeyValueEncodingType.SEPARATED
        );

        try {
            Consumer<KeyValue<GenericRecord, GenericRecord>> consumer = pulsarClient.newConsumer(iotSensorSchemaC)
                    .topic(topicName)
                    .subscriptionName("myapptestsub")
                    .subscribe();

            for (int i = 0; i < 20; i++) {
                Message<?> message = consumer.receive();
                if (message != null) {
                    consumer.acknowledge(message);

                    KeyValue<GenericRecord, GenericRecord> messageValue =
                            (KeyValue<GenericRecord, GenericRecord>) message.getValue();
                    GenericRecord msgKey = messageValue.getKey();
                    GenericRecord msgPayload = messageValue.getValue();

                    System.out.println("  received message " + i);
                    System.out.println("    key: " + printGenericRecord(msgKey));
                    System.out.println("    properties: " + message.getProperties());
                    System.out.println("    payload:  " + printGenericRecord(msgPayload));
                }
            }

            if (consumer != null)
                consumer.close();
        }
        catch (PulsarClientException pce) {
            pce.printStackTrace();
        }
    }

    private static void recvMsgWithStrKey(PulsarClient pulsarClient, String topicName) {

        // receive message from topic 2
        System.out.println("\n\nReceiving messages from topic: " + topicName);
        System.out.println("----------------------------------------");

        //AvroSchema<IotSensorVal> iotSensorSchemaC = AvroSchema.of(IotSensorVal.class);
        Schema<GenericRecord> iotSensorSchemaC = Schema.AUTO_CONSUME();

        try {
            Consumer<GenericRecord> consumer = pulsarClient.newConsumer(iotSensorSchemaC)
                    .topic(topicName)
                    .subscriptionName("myapptestsub")
                    .subscribe();
            for (int i = 0; i < 20; i++) {
                Message<?> message = consumer.receive();
                if (message != null) {
                    consumer.acknowledge(message);

                    GenericRecord msgPayload = (GenericRecord) message.getValue();

                    System.out.println("  received message " + i);
                    System.out.println("    key: " + message.getKey());
                    System.out.println("    properties: " + message.getProperties());
                    System.out.println("    payload:  " + printGenericRecord(msgPayload));
                }
            }

            if (consumer != null)
                consumer.close();
        }
        catch (PulsarClientException pce) {
            pce.printStackTrace();
        }
    }

    public static void main(String[] args) throws PulsarClientException {
        PulsarClient pulsarClient = PulsarClient.builder()
                .serviceUrl(AvroSchemaUtil.PULSAR_SVC_URL)
                .build();

        recvMsgWithAvroKey(pulsarClient, AvroSchemaUtil.TOPIC1);
        recvMsgWithStrKey(pulsarClient, AvroSchemaUtil.TOPIC2);

        if (pulsarClient != null)
            pulsarClient.close();

        System.exit(0);
    }
}
