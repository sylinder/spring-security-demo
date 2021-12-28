create table t_user (
	user_id bigint not null auto_increment,
    username varchar(50) not null,
    password varchar(255),
    primary key (user_id)
);



create table t_role (
	id bigint not null auto_increment,
    user_id bigint not null,
    role_name varchar(50),
    primary key (id)
);

-- need to call BCryptPasswordEncoder.encode(password) and insert into t_user
insert into t_user(username, password) value('caps', '$2a$10$Q0J73zO5ke5/iDOjDn3yxeWzNB2E4OqG8cGwklpU6qwK5SCItvkG6'); --password is 123456
insert into t_user(username, password) value('sylinder', '$2a$10$2TIx2I99qsy/vBx1jlsjTu4Ozh6PdYMIIZEcXJL7BovrWnCxG02JS'); --password is 123456

insert into t_role(user_id, role_name) value (1, 'ADMIN');
insert into t_role(user_id, role_name) value (1, 'DBA');
insert into t_role(user_id, role_name) value (2, 'USER');