CREATE DATABASE USERS;

CREATE TABLE USERS(
    id integer primary key not null AUTO_INCREMENT,
    fullname varchar(50),
    email varchar(100),
    password varchar(100),
);