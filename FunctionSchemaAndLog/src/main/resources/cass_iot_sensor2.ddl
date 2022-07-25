CREATE KEYSPACE testks WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

CREATE TABLE testks.iot_sensor (
    SiteId text,
    StationId text,
    SensorID text,
    SensorType text,
    ReadingTime text,
    ReadingValue text,
    PRIMARY KEY (SiteId, StationId, SensorID)
);