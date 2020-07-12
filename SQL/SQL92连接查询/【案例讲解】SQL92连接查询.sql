#1.查询所有员工的姓名，部门号和部门名称
SELECT CONCAT(`last_name`,' ',`first_name`) AS 员工名,d.department_id AS 部门号,`department_name` AS 部门名称
FROM employees AS e,departments AS d
WHERE e.`department_id`=d.`department_id`;

#2.查询90号部门员工的job_id和90号部门的location_id
SELECT `job_id`,d.`location_id`
FROM employees AS e,departments AS d
WHERE e.`department_id`= d.`department_id`
AND e.`department_id`=90;

#3.选择所有有奖金的员工的`last_name``department_name``location_id``city`
SELECT `last_name`,d.`department_name`,l.`location_id`,`city`
FROM employees AS e,departments AS d,locations AS l
WHERE e.`department_id`=d.`department_id`
AND d.`location_id`=l.`location_id`
AND e.`commission_pct` IS NOT NULL;

#4.选择`city`再Toronto工作的员工的`last_name``job_id``department_id``department_name`
SELECT `last_name`,`job_id`,d.`department_id`,`department_name`
FROM employees AS e,departments AS d,locations AS l
WHERE e.`department_id`=d.`department_id`
AND d.`location_id`=l.`location_id`
AND city='Toronto';

#5.查询每个工种、每个部门的部门名、工种名和最低工资
SELECT `department_name` AS 部门名,`job_title` AS 工种名,MIN(`salary`) AS 最低工资
FROM employees AS e,departments AS d,jobs AS j
WHERE e.`department_id`=d.`department_id`
AND e.`job_id`=j.`job_id`
GROUP BY `department_name`,`job_title`;

#6.查询每个国家下的部门个数大于2的国家编号
SELECT COUNT(*) AS 部门个数,`country_id` AS 国家编号
FROM departments AS d,locations AS l
WHERE d.`location_id`=l.`location_id`
GROUP BY `country_id`
HAVING COUNT(*)>2;

#7.选择指定员工的姓名，员工号，以及他的管理者的姓名和员工号。结果类似于下面的格式
SELECT CONCAT(e.`last_name`,' ',e.`first_name`) AS 员工姓名,e.`employee_id` AS 员工号,CONCAT(m.`last_name`,' ',m.`first_name`) AS 管理姓名,m.`employee_id` AS 员工号
FROM employees AS e,employees AS m
WHERE e.`manager_id`=m.`employee_id`;





