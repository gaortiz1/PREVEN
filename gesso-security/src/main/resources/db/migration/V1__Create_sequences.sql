create sequence seq_new_user
increment 1
start 1;

create sequence seq_new_person
increment 1
start 1;


INSERT INTO seg_user(usr_id, usr_nick_name, usr_password) VALUES (nextval('seq_new_user'), 'admin', 'qwe123');
