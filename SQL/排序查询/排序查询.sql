#进阶3：排序查询
/*
语法：
    select * from employees [where 筛选条件] [order by 排序列表 [asc|desc]]
特点：
    1、asc代表升序，desc代表降序。不写默认升序。
    2、order by子句中可以支持单个字段、多个字段、表达式、函数、别名
    3、order by子句一般放在查询语句的最后面，limit子句除外
*/

#查询员工信息，要求按工资从高到低排序
SELECT * FROM employees ORDER BY salary DESC;

#查询部门编号大于等于90的员工信息，按入职先后进行排序
SELECT * FROM employees WHERE department_id>=90 ORDER BY hiredate ASC;

#按年薪的高低显示员工的信息和年薪【按别名排序】
SELECT *,salary*12*(1+IFNULL(commission_pct,0)) AS 年薪 FROM employees ORDER BY 年薪 DESC;

#按姓名字节长度显示员工的姓名和工资【按函数排序】
SELECT CONCAT(`last_name`,' ',`first_name`) AS 姓名,salary FROM employees ORDER BY LENGTH(姓名)  ASC;

#查询员工信息先按工资升序，再按员工编号降序【按多个字段排序】
SELECT * FROM employees ORDER BY salary ASC,employee_id DESC;











