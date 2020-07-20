#视图：
/*
含义：虚拟表，和普通表一样使用

应用场景：
    ①多个地方用到同样的查询结果
    ②该查询结果使用的sql语句较复杂

特点：

语法：
    create view 视图名
    as
    查询语句;

视图与表的区别：        创建的关键字          物理空间                        使用
    视图                            create view              只是保存了sql逻辑       主要查
    表                                create table              保存了数据                   增删改查
*/
#一、视图的创建
#1.查询邮箱中包含a字符的员工名、部门名和工种信息
CREATE VIEW my_v1
AS
SELECT CONCAT(`first_name`,' ',`last_name`) AS 员工名,`department_name` AS 部门名,`job_title` AS 工种信息
FROM employees AS e
JOIN departments AS d ON e.`department_id`=d.`department_id`
JOIN jobs AS j ON e.`job_id`=j.`job_id`
WHERE email LIKE '%a%'; 

SELECT * FROM my_v1;


#2.查询各部门的平均工资级别
CREATE VIEW my_v2
AS
SELECT department_id,AVG(salary) AS 平均工资
FROM employees
GROUP BY department_id;

SELECT department_id,j.`grade_level` AS 工资级别
FROM my_v2 AS v
JOIN job_grades AS j
ON v.`平均工资` BETWEEN j.`lowest_sal` AND j.`highest_sal`;


#3.查询平均工资最低的部门名和工资
CREATE VIEW my_v3
AS
SELECT * 
FROM my_v2 
ORDER BY 平均工资 DESC 
LIMIT 1;

SELECT m.*,d.`department_name` AS 部门名
FROM my_v3 AS m
JOIN departments AS d
ON m.`department_id`=d.`department_id`;


#二、视图的修改
#方式一：
/*
create or replace view 视图名
as
查询语句;
*/
CREATE OR REPLACE VIEW my_v3
AS
SELECT job_id AS 工种信息,AVG(salary) AS 平均工资
FROM employees
GROUP BY job_id;

#方式二：
/*
alter view 视图名
as
查询语句;
*/
ALTER VIEW my_v3
AS
SELECT job_id AS 工种信息,AVG(salary) AS 平均工资
FROM employees
GROUP BY job_id;


#三、视图的删除
/*
drop view 视图名,视图名,...;
*/
DROP VIEW my_v1,my_v2,my_v3;


#四、视图的查看
/*
desc 视图名;
show create view 视图名;
*/

#五、视图的更新
CREATE OR REPLACE VIEW my_v4
AS
SELECT `last_name`,email
FROM employees;

SELECT * FROM my_v4;
#1.插入
INSERT INTO my_v4 VALUE ('张飞','ZHANGFEI');

#2.修改
UPDATE my_v4 SET last_name='张无忌' WHERE last_name='张飞';

#3.删除
DELETE FROM my_v4 WHERE last_name='张无忌';

/*
包含以下关键字的视图是不能更新的：
    ①sql语句：分组函数、distinct、group by、having、union或者union all
    ②常量视图
    ③Select中包含子查询
    ④join
    ⑤from一个不能更新的视图
    ⑥where子句的子查询引用了from子句中的表
*/


