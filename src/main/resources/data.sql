insert into department (id,name,created_by,created_at,modified_by,modified_at,version) 
values(1,'电信学院','admin',sysdate(),'admin',sysdate(),0);
insert into department (id,name,created_by,created_at,modified_by,modified_at,version) 
values(2,'计算机学院','admin',sysdate(),'admin',sysdate(),0);

insert into user (id,username,password,name,birthday,sex,department_id,created_by,created_at,modified_by,modified_at,version)
values(1,'adminUsername','adminPassword','adminName','1980-01-11','女',1,'admin',sysdate(),'admin',sysdate(),0);
insert into user (id,username,password,name,birthday,sex,department_id,created_by,created_at,modified_by,modified_at,version)
values(2,'schoolAdmin','schoolAdminPassword','schoolAdminName','1980-01-11','女',1,'admin',sysdate(),'admin',sysdate(),0);
insert into user (id,username,password,name,birthday,sex,department_id,created_by,created_at,modified_by,modified_at,version)
values(3,'departmentAdmin','departmentAdminPassword','departmentAdminAdminName','1980-01-11','女',1,'admin',sysdate(),'admin',sysdate(),0);
insert into user (id,username,password,name,birthday,sex,department_id,created_by,created_at,modified_by,modified_at,version)
values(4,'teacher','teacherPassword','teacherName','1980-05-18','男',2,'admin',sysdate(),'admin',sysdate(),0);
insert into user (id,username,password,name,birthday,sex,department_id,created_by,created_at,modified_by,modified_at,version)
values(5,'maoshiling','maoshilingmm','maoshiling','1992-01-11','女',1,'admin',sysdate(),'admin',sysdate(),0);

insert into role (role_code,role_name,created_by,created_at,modified_by,modified_at,version)
values('admin','超级管理员','admin',sysdate(),'admin',sysdate(),0);
insert into role (role_code,role_name,created_by,created_at,modified_by,modified_at,version)
values('schoolAdmin','学校管理员','admin',sysdate(),'admin',sysdate(),0);
insert into role (role_code,role_name,created_by,created_at,modified_by,modified_at,version)
values('departmentAdmin','院系管理员','admin',sysdate(),'admin',sysdate(),0);
insert into role (role_code,role_name,created_by,created_at,modified_by,modified_at,version)
values('teacher','教师','admin',sysdate(),'admin',sysdate(),0);
insert into role (role_code,role_name,created_by,created_at,modified_by,modified_at,version)
values('student','学生','admin',sysdate(),'admin',sysdate(),0);

insert into category (id,name,created_by,created_at,modified_by,modified_at,version) values(1,'系统管理','admin',sysdate(),'admin',sysdate(),0);
insert into category (id,name,created_by,created_at,modified_by,modified_at,version) values(2,'教师管理','admin',sysdate(),'admin',sysdate(),0);
insert into category (id,name,created_by,created_at,modified_by,modified_at,version) values(3,'学生管理','admin',sysdate(),'admin',sysdate(),0);
insert into category (id,name,created_by,created_at,modified_by,modified_at,version) values(4,'个人信息','admin',sysdate(),'admin',sysdate(),0);

insert into function (id,name,url,category_id,created_by,created_at,modified_by,modified_at,version)
values(1,'系统管理子菜单1','/system/management1',1,'admin',sysdate(),'admin',sysdate(),0);
insert into function (id,name,url,category_id,created_by,created_at,modified_by,modified_at,version)
values(2,'教师管理子菜单1','/teacher/management1',2,'admin',sysdate(),'admin',sysdate(),0);
insert into function (id,name,url,category_id,created_by,created_at,modified_by,modified_at,version)
values(3,'学生管理子菜单1','/student/management1',3,'admin',sysdate(),'admin',sysdate(),0);
insert into function (id,name,url,category_id,created_by,created_at,modified_by,modified_at,version)
values(4,'个人信息子菜单1','/self/management1',4,'admin',sysdate(),'admin',sysdate(),0);

insert into user_role(user_id,role_code) values(1,'admin');
insert into user_role(user_id,role_code) values(2,'schoolAdmin');
insert into user_role(user_id,role_code) values(2,'departmentAdmin');
insert into user_role(user_id,role_code) values(3,'departmentAdmin');
insert into user_role(user_id,role_code) values(3,'teacher');
insert into user_role(user_id,role_code) values(4,'teacher');
insert into user_role(user_id,role_code) values(5,'student');

insert into role_function(role_code,function_id) values('admin',1);
insert into role_function(role_code,function_id) values('admin',2);
insert into role_function(role_code,function_id) values('admin',3);
insert into role_function(role_code,function_id) values('admin',4);

insert into role_function(role_code,function_id) values('schoolAdmin',2);
insert into role_function(role_code,function_id) values('schoolAdmin',3);
insert into role_function(role_code,function_id) values('schoolAdmin',4);

insert into role_function(role_code,function_id) values('departmentAdmin',2);
insert into role_function(role_code,function_id) values('departmentAdmin',3);
insert into role_function(role_code,function_id) values('departmentAdmin',4);

insert into role_function(role_code,function_id) values('teacher',3);
insert into role_function(role_code,function_id) values('teacher',4);

insert into role_function(role_code,function_id) values('student',4);