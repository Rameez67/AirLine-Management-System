create database airlinemanagementsystem;

use airlinemanagementsystem;

create table login(username varchar(20), password varchar(20));

insert login values("admin","admin");
select * from login;
create table passenger (name varchar(50),address varchar(50),nation varchar(50),adhar varchar(30),phone varchar(30),gender varchar(30));
select * from passenger;

create table flight(f_code varchar(20), f_name varchar(30), f_source varchar(40), f_destination varchar(40));
describe flight;
insert into flight values("1001","PIA-1212","ISlamabad","Karachi");
insert into flight values("1002","PIA-1112","Islamabad","Hyderabad");
insert into flight values("1003","PIA-1012","Karachi","Dadu");
insert into flight values("1004","PIA-1002","Karachi","Jacobabad");
insert into flight values("1005","PIA-1432","Jacobabad","Rawalpindi");

select * from flight;

create table reservation(PNR varchar(40),TIC varchar(40),name varchar(50),nation varchar(40),adhar varchar(50), fname varchar(30),fcode varchar(40),src varchar(40),dest varchar(40),ddate varchar(40));
describe reservation;
select * from reservation;

create table cancel(pnr varchar(30),name varchar(30),cancelno varchar(30),fcode varchar(30),date varchar(30));
describe cancel;