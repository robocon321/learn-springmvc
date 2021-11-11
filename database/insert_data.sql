use springmvc;

insert into role(code,name) values('ADMIN','Quản trị');
insert into role(code,name) values('account','Người dùng');

insert into account(username,password,fullname,status)
values('admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','trương tùng lâm',1);
insert into account(username,password,fullname,status)
values('nguyenvana','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn A',1);
insert into account(username,password,fullname,status)
values('nguyenvanb','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn B',1);

INSERT INTO account_role(account_id,role_id) VALUES (1,1);
INSERT INTO account_role(account_id,role_id) VALUES (2,2);
INSERT INTO account_role(account_id,role_id) VALUES (3,2);