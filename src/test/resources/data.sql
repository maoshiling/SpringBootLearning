insert into department (id,name,created_by,created_at,modified_by,modified_at,version) values(3,'测试修改','admin',sysdate(),'admin',sysdate(),0);
insert into department (id,name,created_by,created_at,modified_by,modified_at,version) values(4,'测试删除','admin',sysdate(),'admin',sysdate(),0);
insert into department (id,name,created_by,created_at,modified_by,modified_at,version) values(5,'测试不可删除','admin',sysdate(),'admin',sysdate(),0);

insert into user (id,username,password,name,birthday,sex,department_id,created_by,created_at,modified_by,modified_at,version)
values(6,'测试修改','passwordForModify','nameForModify','1992-01-11','女',5,'admin',sysdate(),'admin',sysdate(),0);
insert into user (id,username,password,name,birthday,sex,department_id,created_by,created_at,modified_by,modified_at,version)
values(7,'测试删除','passwordForDelete','nameForDelete','1992-01-11','女',3,'admin',sysdate(),'admin',sysdate(),0);

insert into role (role_code,role_name,created_by,created_at,modified_by,modified_at,version)
values('testModify','测试修改','admin',sysdate(),'admin',sysdate(),0);
insert into role (role_code,role_name,created_by,created_at,modified_by,modified_at,version)
values('testDelete','测试删除','admin',sysdate(),'admin',sysdate(),0);

insert into category (id,name,created_by,created_at,modified_by,modified_at,version) values(5,'测试修改','admin',sysdate(),'admin',sysdate(),0);
insert into category (id,name,created_by,created_at,modified_by,modified_at,version) values(6,'测试删除','admin',sysdate(),'admin',sysdate(),0);

insert into function (id,name,url,category_id,created_by,created_at,modified_by,modified_at,version)
values(5,'测试修改','/test/modify',5,'admin',sysdate(),'admin',sysdate(),0);
insert into function (id,name,url,category_id,created_by,created_at,modified_by,modified_at,version)
values(6,'测试删除','/test/delete',5,'admin',sysdate(),'admin',sysdate(),0);

insert into role_function(role_code,function_id) values('admin',5);
insert into role_function(role_code,function_id) values('admin',6);

insert into role_function(role_code,function_id) values('schoolAdmin',5);
insert into role_function(role_code,function_id) values('schoolAdmin',6);

insert into role_function(role_code,function_id) values('departmentAdmin',5);
insert into role_function(role_code,function_id) values('departmentAdmin',6);

insert into role_function(role_code,function_id) values('teacher',5);
insert into role_function(role_code,function_id) values('teacher',6);

insert into role_function(role_code,function_id) values('student',5);
insert into role_function(role_code,function_id) values('student',6);