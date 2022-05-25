-- begin SUPPLIER
create table supplier (
    ID bigserial,
    --
    name text not null,
    --
    primary key (ID)
)^
-- end SUPPLIER
-- begin REQUEST
create table request (
    ID bigserial,
    --
    customer_id bigint not null,
    supplier_id bigint not null,
    --
    primary key (ID)
)^
-- end REQUEST
-- begin REQUEST_ITEM
create table request_item (
    ID bigserial,
    --
    product_id bigint not null,
    request_id bigint not null,
    volume bigint not null,
    --
    primary key (ID)
)^
-- end REQUEST_ITEM
-- begin PRODUCT
create table product (
    ID bigserial,
    --
    cost decimal(7, 2) not null,
    name text not null,
    --
    primary key (ID)
)^
-- end PRODUCT
-- begin CUSTOMER
create table customer (
    ID bigserial,
    --
    city text not null,
    name text not null,
    --
    primary key (ID)
)^
-- end CUSTOMER
-- begin UNTITLED_CHART_TYPE
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
)^
-- end UNTITLED_CHART_TYPE
