drop table if exists customer;

create table customer ( 
    id serial primary key, 
    name varchar(100), 
    age int  
);
insert into customer (name,age) values ('Joe Smith', 55);
insert into customer (name,age) values ('Jane Jones', 25);
insert into customer (name,age) values ('Alex Brown', 15);
insert into customer (name,age) values ('George Lee', 30);
