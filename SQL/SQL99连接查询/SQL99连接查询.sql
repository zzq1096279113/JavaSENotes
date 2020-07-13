#二、sql92标准
/*
语法：
    select 查询列表 
    from 表1 别名 【连接类型】
    join 表2 别名 on 连接条件
    【where 筛选条件】
    【group by 分组】
    【having 筛选条件】
    【order by 排序】

内连接：inner
外连接
        左外：left 【outer】
        右外：right 【outer】
        全外：full 【outer】
交叉连接：cross

*/

#1、内连接
/*
语法：
    select 查询列表
    from 表1 别名
    inner join 表2 别名
    on 连接条件
    ......

分类：
    等值连接
    非等值连接
    自连接

特点：
    ①可以添加排序、分组、筛选
    ②inner可以省略
    ③筛选条件放在where后面，连接条件放在on后面，提高分离性
    ④inner join连接和sql92中的等值连接效果是一样的，都是查询多表的交集
*/
#①等值连接
#查询员工名、部门名（调换位置）
SELECT CONCAT(`last_name`,' ',`first_name`) AS 员工名,department_name AS 部门名
FROM employees AS e
JOIN departments AS d 
ON e.`department_id`=d.`department_id`;

#查询名字中包含e的员工名和工种名（筛选）
SELECT CONCAT(`last_name`,' ',`first_name`) AS 员工名,`job_title` AS 工种名
FROM employees AS e
JOIN jobs AS j 
ON e.`job_id`=j.`job_id`
WHERE CONCAT(`last_name`,' ',`first_name`) LIKE '%e%';

#查询部门个数>3的城市名和及其部门个数（分组+筛选）
SELECT `city` AS 城市名,COUNT(*) AS 部门个数
FROM departments AS d
JOIN locations AS l 
ON d.`location_id`=l.`location_id`
GROUP BY `city`
HAVING COUNT(*)>3;

#查询那个部门的员工个数>3的部门名和员工个数，并按降序排列（分组+筛选+排序）
SELECT `department_name` AS 部门名,COUNT(*) AS 员工个数
FROM employees AS e
JOIN departments AS d 
ON e.`department_id`=d.`department_id`
GROUP BY `department_name`
HAVING COUNT(*)>3
ORDER BY 员工个数 DESC;

#查询员工名、部门名、工种名，并按部门名降序（三表连接）
SELECT CONCAT(`last_name`,' ',`first_name`) AS 员工名,`department_name` AS 部门名,`job_title` AS 工种名
FROM employees AS e
JOIN departments AS d 
ON e.`department_id`=d.`department_id`
JOIN jobs AS j 
ON e.`job_id`=j.`job_id`
ORDER BY `department_name` DESC;


#②非等值连接
#查询员工的工资级别
SELECT `salary` AS 工资,`grade_level` AS 工资级别
FROM employees AS e
JOIN job_grades AS g 
ON e.`salary` BETWEEN g.`lowest_sal` AND g.`highest_sal`;

#查询每个工资级别>20的个数，并且按工资级别进行降序排序
SELECT COUNT(*) AS 个数,`grade_level` AS 工资级别
FROM employees AS e
JOIN job_grades AS g
ON e.`salary` BETWEEN g.`lowest_sal` AND g.`highest_sal`
GROUP BY `grade_level`
HAVING COUNT(*)>20
ORDER BY `grade_level` DESC;


#③自连接
#查询姓名中包含字符k的员工名和上级的名称
SELECT CONCAT(e.`last_name`,' ',e.`first_name`) AS 员工名,CONCAT(m.`last_name`,' ',m.`first_name`) AS 上级名
FROM employees AS e
JOIN employees AS m 
ON e.`manager_id`=m.`employee_id`
WHERE CONCAT(e.`last_name`,' ',e.`first_name`) LIKE '%k%';



#2、外连接
/*
    一般用于查询一个表中有，另一个表中没有的记录
特点：①外连接的查询结果为主表中所有记录
                如果从表中有和它匹配的，则显示匹配的值
                如果从表中没有和它匹配的，则显示null
                外连接查询结果=内连接结果+主表中有而从表没有的记录
            ②左外连接中，left join左边的是主表
               右外连接中，right join右边的是主表 
            ③左外和右外交换两表的顺序，可以实现相同的效果
            ④全外连接=内连接+表1有表2没有+表1没有表2有的
*/
#查询男朋友不在男神表的女神名
SELECT g.`name` AS 女神名
FROM beauty AS g
LEFT JOIN boys AS b
ON g.`boyfriend_id`=b.`id`
WHERE boyName IS NULL;

#查询哪个部门没有员工
SELECT d.`department_id` AS 部门
FROM departments AS d
LEFT JOIN employees AS e
ON e.`department_id`=d.`department_id`
WHERE e.`employee_id` IS NULL;



#3、交叉连接：笛卡尔乘积
SELECT e.`employee_id`,d.`department_id`
FROM employees AS e
CROSS JOIN departments AS d;
