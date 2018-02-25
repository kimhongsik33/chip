create table tbl_member(
	user_id varchar(50) not null,
    user_password varchar(50) not null,
    user_name varchar(50) not null,
    email varchar(100),
    register_date timestamp default now(),
    update_date timestamp default now(),
    primary key(user_id)
);