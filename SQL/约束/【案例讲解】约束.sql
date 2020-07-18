CREATE TABLE emp2 (
    id INT(7),
    First_name VARCHAR(25),
    Last_name VARCHAR(25),
    Dept_id INT(7)
);

CREATE TABLE dept2 (
    id INT(7),
    NAME VARCHAR(25)
);
#1. 向表emp2的id列中添加PRIMARY KEY约束（my_emp_id_pk）
 ALTER TABLE emp2 ADD CONSTRAINT my_emp_id_pk PRIMARY KEY(id);
 
 
#2. 向表dept2的id列中添加PRIMARY KEY约束（my_dept_id_pk）
 ALTER TABLE dept2 ADD CONSTRAINT my_dept_id_pk PRIMARY KEY(id);

 
#3. 向表emp2中添加列dept_id，并在其中定义FOREIGN KEY约束，与之相关联的列是dept2表中的id列
ALTER TABLE emp2 ADD FOREIGN KEY(Dept_id) REFERENCES dept2(id);

