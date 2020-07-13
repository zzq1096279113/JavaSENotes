#1. 查询和Zlotkey 相同部门的员工姓名和工资
SELECT CONCAT(`last_name`,' ',`first_name`) AS 员工姓名,salary AS 工资
FROM employees
WHERE department_id=(
    SELECT department_id
    FROM employees
    WHERE `last_name`='Zlotkey'
);


#2. 查询工资比公司平均工资高的员工的员工号，姓名和工资。
SELECT employee_id AS 员工号,CONCAT(`last_name`,' ',`first_name`) AS 员工姓名,salary AS 工资
FROM employees
WHERE salary>(
    SELECT AVG(salary) AS 平均工资
    FROM employees
);


#3. 查询各部门中工资比本部门平均工资高的员工的员工号, 姓名和工资
SELECT employee_id AS 员工号,CONCAT(`last_name`,' ',`first_name`) AS 员工姓名,salary AS 工资
FROM employees AS e
JOIN (
    SELECT department_id,AVG(salary) AS 平均工资
    FROM employees
    GROUP BY department_id
) AS d
ON e.`department_id`=d.`department_id`
WHERE salary>d.平均工资;
 
 
#4. 查询和姓名中包含字母 u 的员工在相同部门的员工的员工号和姓名
SELECT employee_id AS 员工号,CONCAT(`last_name`,' ',`first_name`) AS 员工姓名
FROM employees
WHERE department_id IN (
    SELECT DISTINCT department_id
    FROM employees
    WHERE CONCAT(`last_name`,' ',`first_name`) LIKE '%u%'
);


#5.  查询在部门的location_id 为1700 的部门工作的员工的员工号
SELECT employee_id AS 员工号
FROM employees
WHERE department_id IN (
    SELECT DISTINCT department_id
    FROM departments
    WHERE location_id=1700
);


#6.  查询管理者是K_ing的员工姓名和工资 
SELECT CONCAT(`last_name`,' ',`first_name`) AS 员工姓名,salary AS 工资
FROM employees
WHERE manager_id IN (
    SELECT employee_id
    FROM employees
    WHERE last_name='K_ing'
);


#7.  查询工资最高的员工的姓名，要求first_name和last_name显示为一列，列名为姓.名
SELECT CONCAT(`last_name`,'.',`first_name`) AS '姓.名'
FROM employees
WHERE salary=(
    SELECT MAX(salary) AS 最高工资
    FROM employees
);

