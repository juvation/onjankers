create table configuration
(
	domain varchar(100) not null,
	name varchar(100) not null,
	value varchar(1000) not null,
	default_value varchar(1000) not null,
	primary key (domain, name)
);

create table tasks
(
  id integer primary key,
  class_name varchar(100),
  scheduled_time bigint not null,
  period integer not null,
  parameters varchar(500)
);

create table tasks_id_seq
(
  id integer primary key auto_increment
);
