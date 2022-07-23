package com.example;

public class AvroSchemaUtil {
    // message key is an Avro structure
    public final static String TOPIC1 = "persistent://public/default/mytopic";

    // message key is a simple string
    public final static String TOPIC2 = "persistent://public/default/mytopic2";

    // sensor site count
    public final static int MAX_SENSOR_SITE_CNT = 100;
    // sensor station count per site
    public final static int MAX_SENSOR_STATION_CNT = 5;
    // sensor count per station
    public final static int MAX_SENSOR_CNT = 20;
    public final static String[] AVAILABLE_SENSOR_TYPES = {"pressure", "temperature", "velocity"};

    public final static String PULSAR_SVC_URL = "pulsar://10.101.34.56:6650";
}
