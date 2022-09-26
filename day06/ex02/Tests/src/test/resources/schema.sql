create table if not exists product (
    identifier int primary key IDENTITY ,
    name varchar(50) not null ,
    price int not null
);


