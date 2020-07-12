#进阶6：连接查询
/*
含义：多表查询，当查询的字段来自于多个表时，就会用到连接查询

笛卡尔乘积现象：表1有m行，表2有n行，结果=m*n行
发生原因：没有有效的连接条件
如何避免：添加有效的连接条件

分类：按年代分类：
                sql92标准：只支持内连接
                sql99标准：支持内连接+外连接+交叉连接
                
            按功能分类：
                内连接：
                    等值连接
                    非等值连接
                    自连接
                外连接：
                
                交叉连接
*/

#一、sql92标准
/*1、等值连接
    ①多表等值连接的结果为多表 的交集部分
    ②n表连接至少需要n-1个连接条件
    ③多表的顺序没有要求
    ④一般需要为表起别名
    ⑤可以搭配前面所有的子句使用：分组、排序、筛选
*/

#查询女神名和对应的男神名
SELECT `name`,`boyName` 
FROM `beauty`,`boys` 
WHERE beauty.`boyfriend_id`=boys.`id`;

#查询员工名和对应的部门名
SELECT CONCAT(`last_name`,' ',`first_name`) AS 员工名,`department_name` 
FROM `employees` ,`departments` 
WHERE employees.`department_id`=departments.`department_id`;


#2、为表起别名
#查询员工名、工种号、工种名
SELECT CONCAT(`last_name`,' ',`first_name`) AS 员工名,e.`job_id` AS 工种号,`job_title` AS 工种名 
FROM `employees` AS e,`jobs` AS j 
WHERE e.`job_id`=j.`job_id`;


#3、两个表的顺序可以调换
SELECT CONCAT(`last_name`,' ',`first_name`) AS 员工名,e.`job_id` AS 工种号,`job_title` AS 工种名 
FROM jobs AS j,employees AS e
WHERE e.`job_id`=j.`job_id`;


#4、可以添加筛选
#查询有奖金的员工名、部门名
SELECT CONCAT(`last_name`,' ',`first_name`) AS 员工名,`department_name` AS 部门名 
FROM `employees` AS e,`departments` AS d 
WHERE e.`department_id`=d.`department_id`
AND e.`commission_pct` IS NOT NULL;

#查询城市名中第二个字符为o的部门名和城市名
SELECT `department_name` AS 部门名,`city` AS 城市名 
FROM `departments` AS d,`locations` AS l 
WHERE d.`location_id`=l.`location_id`
AND l.`city` LIKE '_o%';


#5、可以分组
#查询每个城市的部门个数
SELECT `city` AS 城市,COUNT(*) AS 部门个数 
FROM `locations` AS l,`departments` AS d
WHERE d.`location_id`=l.`location_id`
GROUP BY l.`city`;

#查询有奖金的每个部门的部门名和部门领导编号和该部门的最低工资
SELECT `department_name` AS 部门名,d.`manager_id` AS 领导编号,MIN(`salary`) AS 最低工资 
FROM `employees` AS e,`departments` AS d
WHERE e.`department_id`=d.`department_id`
AND e.`commission_pct` IS NOT NULL
GROUP BY `department_name`,d.`manager_id`;


#6、可以排序
#查询每个工种的工种名和员工的个数，并且按员工个数降序
SELECT `job_title` AS 工种名,COUNT(*) AS 员工个数 
FROM `jobs` AS j,`employees` AS e 
WHERE j.`job_id`=e.`job_id`
GROUP BY 工种名
ORDER BY 员工个数 DESC;


#7、可以三表连接
#查询员工名、部门名和所在城市，城市名以s开头
SELECT CONCAT(`last_name`,' ',`first_name`) AS 员工名,`department_name` AS 部门名,`city` AS 所在城市
FROM `employees` AS e,`departments` AS d,`locations` AS l
WHERE e.`department_id`= d.`department_id`
AND d.`location_id`=l.`location_id`
AND l.`city` LIKE 's%'
ORDER BY d.`department_name` DESC;



#2、非等值连接
#查询员工的工资和工资级别
SELECT `salary` AS 工资,`grade_level` AS 工资级别
FROM `employees` AS e,`job_grades` AS g
WHERE e.`salary` BETWEEN g.`lowest_sal` AND g.`highest_sal`;



#3、自连接
#查询员工名和上级的名称
SELECT e.`employee_id` AS Employee_ID,CONCAT(e.`last_name`,' ',e.`first_name`) AS 员工名,m.`employee_id` AS Manager_ID,CONCAT(m.`last_name`,' ',m.`first_name`) AS 上级名 
FROM employees AS e,employees AS m
WHERE e.`manager_id`=m.`employee_id`;











