#1. 运行以下脚本创建表 
CREATE TABLE my_employees(  
    Id INT(10),
    First_name VARCHAR(10),
    Last_name VARCHAR(10),
    Userid VARCHAR(10),
    Salary DOUBLE(10,2)
);
CREATE TABLE users(  
    id INT,
    userid VARCHAR(10),
    department_id INT
);


#2. 显示表 my_employees 的结构
DESC my_employees;


#3. 向 my_employees 表中插入下列数据 
ID  First_name  Last_name  Userid  Salary 
1   patel             Ralph     Rpatel          895 
2   Dancs          Betty      Bdancs        860 
3   Biri               Ben        Bbiri             1100 
4   Newman      Chad     Cnewman    750 
5   Ropeburn    Audrey   Aropebur     1550      
INSERT INTO my_employees
VALUE (1,'patel','Ralph','Rpatel',895),
(2,'Dancs','Betty','Bdancs',860),
(3,'Biri','Ben','Bbiri',1100),
(4,'Newman','Chad','Cnewman',750),
(5,'Ropeburn','Audrey','Aropebur',1550);


#4.  向 users 表中插入数据
 1 Rpatel 10
 2 Bdancs 10
 3 Bbiri 20
 4 Cnewman 30
 5 Aropebur 40
INSERT INTO users
VALUE (1,'Rpatel',10),
(2,'Bdancs',10),
(3,'Bbiri',20),
(4,'Cnewman',30),
(5,'Aropebur',40);

 
#5. 将3号员工的last_name修改为“drelxer”
UPDATE my_employees
SET Last_name='drelxer'
WHERE Id=3;


#6. 将所有工资少于900的员工的工资修改为1000
UPDATE my_employees
SET Salary=1000
WHERE Salary<900;


#7. 将userid为Bbiri的user表和my_employees表的记录全部删除
DELETE u,m
FROM users AS u
JOIN my_employees AS m
ON u.`userid`=m.`Userid`
WHERE u.`userid`='Bbiri';


#8. 删除所有数据 
TRUNCATE TABLE my_employees;
TRUNCATE TABLE users;


#9. 检查所作的修正 
SELECT * FROM my_employees;
SELECT * FROM users;

