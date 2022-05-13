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
