#1.创建表dept1
NAME        NULL?   TYPE 
id                                INT(7) 
NAME                        VARCHAR(25) 

CREATE TABLE dept1 (
    id INT(7),
    NAME VARCHAR(25)
);


#2.将表departments中的数据插入新表dept2中
CREATE TABLE dept2
SELECT * FROM myemployees.`departments`;


#3.创建表emp5
NAME            NULL?   TYPE
id                                    INT(7)
First_name                   VARCHAR (25) 
Last_name                   VARCHAR(25) 
Dept_id                         INT(7) 

CREATE TABLE emp5 (
    id INT(7),
    First_name VARCHAR(25),
    Last_name VARCHAR(25),
    Dept_id INT(7)
);


#4.将列Last_name的长度增加到50
ALTER TABLE emp5 MODIFY `Last_name` VARCHAR(50);


#5.根据表employees创建employees2
CREATE TABLE employees2 LIKE myemployees.employees;


#6.删除表emp5
DROP TABLE IF EXISTS emp5;


#7.将表employees2重命名为emp5
ALTER TABLE employees2 RENAME TO emp5;
 
 
#8.在表emp5中添加新列test_column，并检查所作的操作
ALTER TABLE emp5 ADD test_column INT;


#9.直接删除表emp5中的列job_id
ALTER TABLE emp5 DROP job_id;

