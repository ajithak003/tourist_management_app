create table user_details(
user_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 1000,
name varchar(100) not null,
email_id varchar(100) not null UNIQUE,
mobile_no number(20) not null,
password varchar(30) not null,
CONSTRAINT pk_user_id primary key(user_id)
);
describe user_details;
select * from user_details;

alter table user_details add wallet number(30) default 0;
drop table users_details;

create table admin_details(
admin_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 1,
name varchar(100) not null,
email_id varchar(100) not null UNIQUE,
mobile_no number(20) not null,
password varchar(30) not null,
CONSTRAINT pk_admin_id primary key (admin_id)
);
describe admin_details;
drop table admin_details;


select * from admin_details;

insert into admin_details(name,email_id,mobile_no,password) values('ajith','ajith@admin.com',7834661290,'Ajith@123');
insert into admins_table(name,email_id,mobile_no,password) values('saruk','saruk@admin.com',8144873768,'Saruk@123');



create table package_modes (
package_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 100,
package_name varchar(100) not null,
package_price_2n number (30) not null,
package_price_3n number (30) not null,
package_price_4n number (30) not null,
season varchar(60) not null,
protocols varchar2(3999) not null,
description varchar2(3999) not null, 
check(package_price_2n>0),
check(package_price_3n>0),
check(package_price_4n>0),
CONSTRAINT pk_package_id primary key (package_id)
);

insert into package_modes(package_name,package_price_2n,package_price_3n,package_price_4n,season,protocols,description) values('kashmir',2000,3000,4000,'winter',);
update user_details set package_name='kashmir',package_price_2n=3000,package_price_3n=5500,package_price_4n=7500,season=snow,protocols=' No restriction on interstate travel as per latest Guidelines issued by the state government
' ,description='Jammu and Kashmir is home to several valleys such as the Kashmir Valley, Chenab Valley, Sindh Valley and Lidder Valley. Some major tourist attractions in Jammu and Kashmir are Srinagar, the Mughal Gardens, Gulmarg, Pahalgam, Patnitop and Jammu.
'where package_id=100;
describe package_modes;
drop table package_modes CASCADE CONSTRAINTS;
select * from package_modes;
create table flights_details(
flight_no  NUMBER GENERATED ALWAYS AS IDENTITY START WITH 200,
flight_name varchar(100) not null,
depature varchar(100) not null,
destination varchar (100) not null,
depature_date_time TIMESTAMP not null,
arrival_date_time TIMESTAMP not null,
business_class_fare number (30) not null,
economic_class_fare number (30) not null,
status varchar (60) not null,
check(business_class_fare>0),
check(economic_class_fare>0),
CONSTRAINT pk_flight_no primary key (flight_no)
);
select * from flights_details;
describe flights_details;
drop table flights_details CASCADE CONSTRAINTS;

create table hotel_details(
hotel_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 600 ,
location varchar (100) not null,
hotel_name varchar(100) not null,
room_type_mid_range_price varchar(100) not null,
room_type_premium_price varchar(100) not null,
check(room_type_premium_price>0),
check (room_type_mid_range_price>0),
CONSTRAINT pk_hotel_id primary key (hotel_id)
);


describe hotel_details;

select * from hotel_details where location='kashmir';
delete from hotel_details where hotel_id=600
select * from hotel_details;
drop table hotel_details  CASCADE CONSTRAINTS;
insert into hotel_details(location,hotel_name,room_type_mid_range_price,room_type_premium_price) values('kashmir','white snow',2500,3750);
create table booking_details(
booking_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 300,
user_id number not null,
package_id number not null,
flight_no number not null,
hotel_id number not null,
number_of_person number not null,
start_date date not null,
end_date date  not null,
total_price number(30) not null,
status varchar(30) default 'confirmed',
booking_date TIMESTAMP default sysdate, 
check(total_price>0),
CONSTRAINT pk_booking_id primary key (booking_id),
CONSTRAINT fk_user_id FOREIGN key (user_id) REFERENCES user_details (user_id),
CONSTRAINT fk_package_id FOREIGN key (package_id) REFERENCES package_modes (package_id),
CONSTRAINT fk_flight_no FOREIGN key (flight_no) REFERENCES flights_details (flight_no),
CONSTRAINT fk_hotel_id FOREIGN key (hotel_id) REFERENCES hotel_details (hotel_id)
);

describe booking_details;
drop table booking_details CASCADE CONSTRAINTS;
select * from booking_details;

create table users_feedback(
feedback_id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 800,
booking_id number not null,
package_id number not null,
rating varchar (30),    
describtion varchar(200),
CONSTRAINT pk_feedback_id primary key (feedback_id),
CONSTRAINT fk_feedback_booking_id FOREIGN key (booking_id) REFERENCES booking_details (booking_id),
CONSTRAINT fk_feedback_package_id FOREIGN key (package_id) REFERENCES package_modes (package_id)
);
drop table users_feedback CASCADE CONSTRAINTS;
describe users_feedback;

update users_table set name='manoj',mobile_no='', password=? where email_id='"+user.getEmail()+"';


select email_id from users_table where email_id='ajith@gmail.com';
delete user_details  where email_id='hari@gmail.com';

select flight_no, flight_name,depature,destination, depature_date_time,arrival_date_time,business_class_fare,economic_class_fare,status from flights_details ;
where to_char(depature_date_time,'dd')=21;
select * from flights_details;

select * from flights_details where destination='kashmir' and to_char(depature_date_time,'dd-mm-yyyy')='21-12-2021';

select * from booking_details inner join 
