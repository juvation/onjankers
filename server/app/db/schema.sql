create table configuration
(
	domain varchar(100) not null,
	name varchar(100) not null,
	value varchar(1000) not null,
	default_value varchar(1000) not null,
	primary key (domain, name)
);

create table jankers
(
  id integer primary key,
  who varchar(1000) not null,
  why varchar(1000) not null,
  create_timestamp bigint not null
);

create table jankers_id_seq
(
  id integer primary key auto_increment
);

