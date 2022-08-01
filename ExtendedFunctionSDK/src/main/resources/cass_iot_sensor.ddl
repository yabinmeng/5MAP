CREATE KEYSPACE testks WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

CREATE TABLE testks.iot_sensor (
    siteid int,
    stationid int,
    sensorid text,
    sensortype text,
    readingtime int,
    readingvalue float,
    PRIMARY KEY (SiteId, StationId, SensorID)
);