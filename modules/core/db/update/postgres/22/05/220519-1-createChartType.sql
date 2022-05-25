create table UNTITLED_CHART_TYPE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SERIAL_CHART varchar(50),
    PIE_TYPE varchar(50),
    RADAR_CHART varchar(50),
    --
    primary key (ID)
);