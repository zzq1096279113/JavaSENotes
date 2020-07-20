#1、创建视图emp_v1，要求查询电话号码以‘011’开头的员工姓名和工资、邮箱
CREATE OR REPLACE VIEW emp_v1
AS
SELECT CONCAT(`first_name`,' ',`last_name`) AS 员工姓名,salary AS 工资,email AS 邮箱
FROM employees
WHERE phone_number LIKE '011%';


#2、要求将视图emp_v1修改为查询电话号码以‘011’开头的并且邮箱中包含e字符的员工姓名和邮箱、电话号码
CREATE OR REPLACE VIEW emp_v1
AS
SELECT CONCAT(`first_name`,' ',`last_name`) AS 员工姓名,email AS 邮箱,phone_number AS 电话号码
FROM employees
WHERE phone_number LIKE '011%' AND email LIKE '%e%';


#3、创建视图emp_v2，要求查询部门的最高工资高于12000的部门信息
CREATE OR REPLACE VIEW emp_v2
AS
SELECT d.*,m.max_salary
FROM departments AS d
JOIN (
    SELECT MAX(salary) AS max_salary,department_id
    FROM employees
    GROUP BY department_id
    HAVING MAX(salary)>12000
) AS m
ON d.`department_id`=m.`department_id`;


#4、删除刚才的emp_v2和emp_v1
DROP VIEW emp_v1,emp_v2;

