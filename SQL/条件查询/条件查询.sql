#进阶2：条件查询
/*
语法：
    select 查询列表 from 表名 where 筛选条件;
1.按条件表达式筛选：
    条件运算符：< > <= >= = !=
2.按逻辑表达式筛选：
    逻辑运算符：&& || ! and or not 
3.模糊查询：
    like ：%任意多个字符，包含0个字符；
               _任意单个字符。
    between and：提高语句简洁度，包含边界值，必须是小数在前大数在后。
    in：判断某字符的值是否属于in列表中的某一项，只要检索条件匹配in后面任何一个条件，就会符合检索条件。
    
*/

#1.按条件表达式筛选：
#查询所有工资大于等于10000的员工信息
    SELECT * FROM employees WHERE salary>10000;

#查询部门编号不等于90号的员工名和部门编号
    SELECT CONCAT(`last_name`,' ',`first_name`) AS 员工名,`department_id` AS 部门编号 FROM `employees` WHERE department_id!=90;


#2.按逻辑表达式筛选：
#查询工资在10000到20000之间的员工名、工资和奖金
    SELECT CONCAT(`last_name`,' ',`first_name`) AS 员工名,salary AS 工资,`commission_pct` AS 奖金 FROM employees WHERE salary>=10000 AND salary<=20000;

#查询部门编号不是在90-110之间，或工资高于15000的员工信息
    SELECT * FROM employees WHERE `department_id`<90 OR `department_id`>110 OR salary > 15000;


#3.模糊查询：
#①like
#查询员工名中包含字符a的员工信息
SELECT * FROM employees WHERE `last_name` LIKE '%a%';

#查询员工名中第三个字符为n的，第五个字符为l的员工名和工资
SELECT CONCAT(`last_name`,' ',`first_name`) AS 员工名,salary AS 工资 FROM employees WHERE`last_name` LIKE '__n_l%';

#查询员工名中第二个字符为_的员工名
SELECT last_name FROM employees WHERE last_name LIKE '_\_%';

#②between and
#查询所有工资在10000到20000之间的员工
SELECT * FROM employees WHERE salary BETWEEN 10000 AND 20000; 

#③in
#manager_id是102或者103或者114的员工信息
SELECT * FROM employees WHERE manager_id IN (102,103,114);

#④is null
#查询出所有没有年底奖金的员工信息
SELECT * FROM employees WHERE commission_pct IS NULL;

#查询出所有年底有奖金的员工信息
SELECT * FROM employees WHERE commission_pct IS NOT NULL;


#安全等于：<=>
SELECT * FROM employees WHERE commission_pct <=> NULL;

SELECT * FROM employees WHERE salary <=> 12000;

