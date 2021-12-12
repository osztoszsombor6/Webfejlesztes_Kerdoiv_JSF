insert into DEPARTMENT_MASTER values(1001,'IT'); 
insert into DEPARTMENT_MASTER values(1002,'Finance'); 
insert into DEPARTMENT_MASTER values(1003,'HR'); 
insert into DEPARTMENT_MASTER values(1004,'Operations');  

insert into EMP_INFO(emp_Id, EMP_NAME, PASSWORD, EMAIL_ID, DEPT_ID ) values(101,'Bharat','1234','bharat@email.com',1001);
insert into EMP_INFO(emp_Id, EMP_NAME, PASSWORD, EMAIL_ID, DEPT_ID ) values(103,'Singh','2345','singh@email.com',1002);
insert into EMP_INFO(emp_Id, EMP_NAME, PASSWORD, EMAIL_ID, DEPT_ID ) values(102,'xyz','3456','xyz@email.com',1003);
insert into EMP_INFO(emp_Id, EMP_NAME, PASSWORD, EMAIL_ID, DEPT_ID ) values(104,'shoaib','shoaib','shoaib@email.com',1004);

insert into KERDOIV(id, title) values(101,'Teszt_kerdoiv1');
insert into KERDOIV(id, title) values(103,'Teszt_kerdoiv2');
insert into KERDOIV(id, title) values(102,'Teszt_kerdoiv3');
insert into KERDOIV(id, title) values(104,'Teszt_kerdoiv4');

insert into KERDES(id, kerdes_szoveg, kerdoiv_id) values(201,'Teszt_kerdes1', 101);
insert into KERDES(id, kerdes_szoveg, kerdoiv_id) values(202,'Teszt_kerdes2', 101);
insert into KERDES(id, kerdes_szoveg, kerdoiv_id) values(203,'Teszt_kerdes3', 103);
insert into KERDES(id, kerdes_szoveg, kerdoiv_id) values(204,'Teszt_kerdes4', 103);
insert into KERDES(id, kerdes_szoveg, kerdoiv_id) values(205,'Teszt_kerdes5', 104);
insert into KERDES(id, kerdes_szoveg, kerdoiv_id) values(206,'Teszt_kerdes6', 103);