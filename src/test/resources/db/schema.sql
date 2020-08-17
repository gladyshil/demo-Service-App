create table if not exists Employee
(
	id int auto_increment primary key,
	first_name varchar(50),
	last_name varchar(50),
	job varchar(50),
	department varchar(50),
	salary int,
	createdAt  datetime(6) default CURRENT_TIMESTAMP(6) not null,
	updatedAt datetime(6) default CURRENT_TIMESTAMP(6) not null
);



