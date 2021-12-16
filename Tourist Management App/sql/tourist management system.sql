create table users_table(
user_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 1000,
name varchar(100) not null,
email_id varchar(100) not null UNIQUE,
mobile_no number(20) not null,
password varchar(30) not null,
CONSTRAINT pk_user_id primary key(user_id)
);
describe users_table;
select * from users_table;

drop table users_table;

create table admins_table(
admin_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 1,
name varchar(100) not null,
email_id varchar(100) not null UNIQUE,
mobile_no number(20) not null,
password varchar(30) not null,
CONSTRAINT pk_admin_id primary key (admin_id)
);
describe admins_table;
drop table admins_table;


select * from admins_table;

insert into admins_table(name,email_id,mobile_no,password) values('gopi','gopi@admin.com',7834661290,'Gopi@123');
insert into admins_table(name,email_id,mobile_no,password) values('saruk','saruk@admin.com',8144873768,'Saruk@123');

create table gaids (
gaid_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 30,
admin_id number not null,
gaid_name varchar(100) not null,
email_id varchar (100) not null UNIQUE,
mobile_no number(20) not null,
password varchar(30) not null,
gaid_address varchar(50) not null,
CONSTRAINT pk_gaid_id primary key (gaid_id)
);
drop table gaids;
describe gaids;


create table package_modes(
package_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 100,
package_name varchar(100) not null,
package_price_2n number (20,2) not null,
package_price_3n number (20,2) not null,
package_price_4n number (20,2) not null,
season varchar(60) not null,
protocols varchar(300) not null,
forcast varchar(200) not null,
description varchar (1000) not null, 
CONSTRAINT pk_package_id primary key (package_id)
);
describe package_modes;
drop table package_modes;

create table flights(
package_id number not null,
flight_no  NUMBER GENERATED ALWAYS AS IDENTITY START WITH 200,
flight_name varchar(100) not null,
destination varchar (100) not null,
arrival varchar(100) not null,
depature_time  TIMESTAMP not null,
arrival_time TIMESTAMP  not null,
business_class_fare number (30,2) not null,
economic_class_fare number (30,2) not null,
status varchar (60) not null,
CONSTRAINT pk_flight_no primary key (flight_no)
);

describe flights;
drop table flights;

create table bookings(
booking_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 300,
user_id number not null,
package_id number not null,
flight_no number not null,
package_name varchar(100) not null,
number_of_person number not null,
start_date timestamp not null,
end_date timestamp  not null,
total_price number(30) not null,
gaid_id varchar(30),
CONSTRAINT pk_booking_id primary key (booking_id)
);
describe bookings;
drop table bookings;

create table cancel_bookings(
cancel_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 600,
booking_id number not null,
user_id number not null,
package_id number not null,
flight_no number not null,
package_name varchar(100) not null,
number_of_person number not null,
start_date timestamp not null,
end_date timestamp  not null,
total_price number(30,2) not null,
gaid_id number,
CONSTRAINT pk_cance_booking_id primary key (booking_id)
);
describe cancel_bookings;
drop table cancel_bookings;

create table users_feedback(
feedback_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 800,
package_id number not null,
booking_id number not null,
package_name varchar(100) not null,
start_date timestamp,
end_date timestamp not null,
rating varchar (30),
describtion varchar(200)
);
drop table users_feedback;
describe users_feedback;

update users_table set name='manoj',mobile_no='' and password=? where email_id='"+user.getEmail()+"'





