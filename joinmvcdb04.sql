CREATE DATABASE joinmvcdb04;
use joinmvcdb04;

create table user(
    id VARCHAR(20),
    pw VARCHAR(20),
    name VARCHAR(20),
    tel VARCHAR(20),
    email VARCHAR(30),
    field VARCHAR(20),        -- intended field
    skill VARCHAR(20),        -- programming skill
    major VARCHAR(20)        -- major
);

select * from user;
