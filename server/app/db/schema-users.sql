create table users
(
	-- regular users component columns
	
	id integer primary key,
	login varchar(100) not null,
	password varchar(100),
	email varchar(100),
	is_admin varchar(1) not null default 'N',
	screen_name varchar(100),
	service varchar(100),
	service_user_id varchar(100),
	profile_image_url varchar(500),
	payments_user_id varchar(100),
	confirmation_token varchar(100),
	confirmed varchar(1) not null default 'N',
	create_timestamp bigint not null

);

create table users_id_seq
(
	id integer primary key auto_increment
);

