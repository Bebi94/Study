create database bkacad;
use bkacad;
create table students (
 id INT PRIMARY KEY,
 name VARCHAR(50),
 dob DATE
);
insert into students (id,name,dob) values (1,"John","1990-10-19");
insert into students (id,name,dob) values (2,"Dave","1991-12-07");
insert into students (id,name,dob) values (3,"Terry","1992-06-04");
insert into students (id,name,dob) values (4,"Henry","1995-07-14");

