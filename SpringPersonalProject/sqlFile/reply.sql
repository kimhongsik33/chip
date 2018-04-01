create table tbl_reply(
	reply_id int not null auto_increment,
	board_id int not null default 0,
	replyContent varchar(1000) not null,
	replyer varchar(50) not null,
	register_date timestamp not null default now(),
	update_date timestamp not null default now(),
	primary key(reply_id)
);