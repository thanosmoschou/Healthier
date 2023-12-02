create database health;

use health;

create table doctors(
    username varchar(30),
    password varchar(30),
    email varchar(30),
    doctorSSN varchar(5) primary key,
    phone varchar(10)
);

create table appointments(
    firstname varchar(10),
    lastname varchar(10),
    email varchar(30),
    patientSSN varchar(5),
    phone varchar(10),
    appointmentDate date, 
    doctorSSN varchar(5),
    primary key(patientSSN, appointmentDate),
    foreign key (doctorSSN) references doctors(doctorSSN)
)