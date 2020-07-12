#进阶5：分组查询
/*
语法：selet 分组函数,列 from 表 [where 筛选条件] group by 分组的列表 [order by 子句]
注意：查询列表必须特殊，要求是分组函数和group by后出现的字段
特点：1、分组查询中的筛选条件分为两类：
                                        数据源                         位置                                      关键字
            分组前筛选        原始表                         group by子句的前面           where
            分组前筛选        分组后的结果集         group by子句的前面           having
                ①分组函数做条件肯定放在having子句中
                ②能使用分组前筛选的，就优先考虑使用分组前筛选
            2、group by支持单个字段分组，也支持多个字段分组（用,隔开）
            3、也可以添加排序
*/

#查询每个工种的最高工资
SELECT `job_id`,MAX(salary) AS 最高工资 
FROM employees 
GROUP BY `job_id`;

#查询每个位置上的部门个数
SELECT `location_id`,COUNT(`department_id`) AS 部门个数 
FROM departments 
GROUP BY `location_id`;
 
 
 #原先表中有的信息：where
#查询邮箱中包含a字符的，每个部门的平均工资
SELECT `department_id`,AVG(`salary`)  AS 平均工资 
FROM employees 
WHERE email LIKE '%a%' 
GROUP BY `department_id` ;

#查询有奖金的每个领导手下员工的最高工资
SELECT manager_id AS 领导,MAX(salary) AS 最高工资 
FROM employees 
WHERE commission_pct IS NOT NULL 
GROUP BY `manager_id`;


#原先表中没有的信息：having
#查询那个部门的员工个数大于2：①查询每个部门的员工个数 ②根据一的结果进行筛选，查询员工个数大于2的部门
SELECT department_id AS 部门,COUNT(*)AS 员工个数 
FROM employees 
GROUP BY 部门 
HAVING 员工个数>2 ;

#查询每个工种有奖金的员工的最高工资>12000的工种编号和最高工资
SELECT job_id AS 工种,MAX(salary) AS 最高工资 
FROM employees 
WHERE commission_pct IS NOT NULL 
GROUP BY job_id 
HAVING 最高工资>12000;

#查询领导编号>102的每个领导手下的最低工资>5000的领导编号是哪个，以及其工资
SELECT `manager_id` AS 领导编号,MIN(`salary`) AS 最低工资 
FROM employees 
WHERE `manager_id`>102 
GROUP BY `manager_id` 
HAVING 最低工资>5000;


#按表达式或函数分组
#按员工姓名的长度分组，查询每一组的员工个数，筛选员工个数大于5
SELECT COUNT(*) AS 员工个数 
FROM employees 
GROUP BY LENGTH(CONCAT(`last_name`,' ',`first_name`)) 
HAVING COUNT(*)>5;


#按多个字段分组
#查询每个部门每个工种的平均工资
SELECT AVG(`salary`) AS 平均工资,`department_id` AS 部门,`job_id` AS 工种 
FROM employees 
GROUP BY `department_id`,`job_id`;


#添加排序
#查询每个部门每个工种的平均工资，按平均工资的高低显示
SELECT AVG(`salary`) AS 平均工资,`department_id` AS 部门,`job_id` AS 工种 
FROM employees 
WHERE `department_id` IS NOT NULL 
GROUP BY `department_id`,`job_id`
HAVING 平均工资>10000
ORDER BY 平均工资 DESC;





