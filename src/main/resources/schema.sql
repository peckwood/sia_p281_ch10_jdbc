create table user (
	id identity,
	age int(3),
	username varchar(20) unique,
	email varchar(30),
	nationality varchar(20)
);