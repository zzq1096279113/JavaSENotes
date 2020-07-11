#进阶1：基础查询
/*
语法：
select 查询列表 from 表名;
1、可以查询表中的字段、常量值、表达式、函数
2、查询的结果是一个虚拟的表格
*/

USE myemployees;

#1.查询单个字段
SELECT last_name FROM employees;
 
#2.查询多个字段
SELECT last_name,salary,email FROM employees;

#3.查询表中所有字段
#方式一：
SELECT # 
  `employee_id`,
  `first_name`,
  `last_name`,
  `email`,
  `phone_number`,
  `job_id`,
  `salary`,
  `commission_pct`,
  `manager_id`,
  `department_id`,
  `hiredate` 
FROM
  employees ;
  
#方式二：
  SELECT * FROM employees;# *可选取整个表
  
#4.查询常量值
  SELECT 100;
  SELECT 'john';

#5.查询表达式
SELECT 100%98;

#6.查询函数
SELECT VERSION();

#7.起别名（起外号）
    #①便于理解
    #②如果要查询的字段有重名的情况，使用别名可以区分开
#方式一：使用as
SELECT 100%95 AS 结果;
SELECT `last_name` AS 姓, `first_name` AS 名 FROM employees; 
#方式二：使用空格
SELECT `last_name` 姓, `first_name` 名 FROM employees;
SELECT salary AS "out put" FROM employees;

#8.去重   在字段名前面加上DISTINCT
SELECT DISTINCT department_id FROM employees;

#9.+号的作用：sql中的加号只有一个运算符的功能
/*
select 100+90;两个操作数都是数值型，则做加法运算
    其中一方为字符型，另一方为数值型，则试图将字符型数值转换为数值型
select '123' + 90;       如果转换成功，则继续做加法运算；
select 'John' + 90;     如果转换失败，则将字符型数值转换成0；
select null + 313;       只要有其中一方为null，结果肯定为null。
*/


SELECT CONCAT(`last_name`,' ',`first_name`) AS 姓名 FROM employees;








