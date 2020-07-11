#二、分组函数
/*
功能：用作统计使用，又被称为聚合函数或统计函数或组函数。
分类：sum 和、avg 平均值、max 最大值、min 最小值、count 个数。
特点：1、sum、avg一般用于处理数值型，max、min、count可以处理任何类型
            2、以上分组函数都忽略null值
            3、可以和distinct搭配实现去重的运算
            4、count函数的的详细介绍：一般使用COUNT(*)用作统计行数
            5、和分组函数一同查询的字段要求是group by后的字段
*/

#1、简单使用
SELECT SUM(salary) FROM employees;
SELECT AVG(salary) FROM employees;
SELECT MIN(salary) FROM employees;
SELECT MAX(salary) FROM employees;
SELECT COUNT(salary) FROM employees;
SELECT SUM(salary) AS 和, ROUND(AVG(salary),2) AS 平均值 FROM employees;

#2、支持的参数类型
SELECT SUM(`last_name`),AVG(`last_name`) FROM employees;#无意义
SELECT SUM(`hiredate`),AVG(`hiredate`) FROM employees;
SELECT MAX(`last_name`) ,MIN(`first_name`) FROM employees;
SELECT COUNT(`first_name`),COUNT(`commission_pct`) FROM employees;

#3、是否忽略null
SELECT SUM(`commission_pct`),AVG(`commission_pct`) FROM employees;
SELECT MAX(`commission_pct`) ,MIN(`commission_pct`) FROM employees;

#4、和distinct搭配
SELECT SUM(DISTINCT salary) FROM employees;
SELECT COUNT(DISTINCT salary) FROM employees;

#5、函数的详细介绍
SELECT COUNT(salary) FROM employees;
SELECT COUNT(*) FROM employees;#统计行数
SELECT COUNT(1) FROM employees;
SELECT COUNT('zzq') FROM employees;
/*效率
MYISAM存储引擎下，COUNT(*)的效率高
INNODB存储引擎下，COUNT(*)和COUNT(1)的效率差不多，比COUNT(字段)效率高
*/

#6、和分组函数一同查询的字段有限制





