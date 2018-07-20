create table Products (
    id serial primary key not null,
    name varchar(100),
    sku  varchar(100),
    value decimal(10,2),
    type varchar(100)
);