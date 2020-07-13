#进阶7：子查询
/*
含义：
    出现在其他语句中的select语句，称为子查询或内查询
    外部的查询语句，称为主查询或外查询

分类：
    按出现位置：
        select后面：支持标量子查询
        from后面：支持表子查询
        where/having后面：支持标量子查询（单行）、列子查询（多行）★
        exists后面（相关子查询）：支持表子查询
    按结果集的行列数：
        标量子查询（结果只有一行一列）
        列子查询（结果只有一列多行）
        行子查询（结果只有一行多列）
        表子查询（一般结果为多行多列）

*/
#一、where或having后面
/*特点：
    ①子查询放在小括号内
    ②子查询一般放在条件的右侧
    ③标量子查询一般搭配单行操作符（条件操作符）使用
      列子查询一般搭配多行操作符使用
    ④子查询的执行优于主查询的执行，主查询的条件用到了主查询的结果

*/
#1、标量子查询
#查询工资比 Abel 高的员工信息
SELECT * 
FROM employees 
WHERE `salary`>(
    SELECT `salary` 
    FROM employees 
    WHERE `last_name`='Abel'
);

#查询`job_id`与141号员工相同，`salary`比143号员工多的员工姓名，`job_id`和工资
SELECT  CONCAT(`last_name`,' ',`first_name`) AS 员工姓名,`job_id`,`salary` AS 工资
FROM employees
WHERE job_id=(
    SELECT job_id
    FROM employees
    WHERE employee_id=141
) AND salary>(
    SELECT salary
    FROM employees
    WHERE employee_id=143
);

#查询公司工资最少的员工的last_name，job_id和salary
SELECT last_name,job_id,salary
FROM employees
WHERE salary=(
    SELECT MIN(salary)
    FROM employees
);

#查询最低工资大于50号部门最低工资的部门id及其最低工资
SELECT department_id AS id,MIN(salary) AS 最低工资
FROM employees
GROUP BY department_id
HAVING MIN(salary)>(
    SELECT MIN(salary)
    FROM employees
    WHERE department_id=50
);


#2、列子查询（多行子查询）
#查询`location_id`是1400或1700的部门中所有员工的姓名
SELECT CONCAT(`last_name`,' ',`first_name`) AS 员工姓名
FROM employees
WHERE department_id IN(
    SELECT DISTINCT department_id
    FROM departments
    WHERE location_id IN(1400,1700)
);

#查询其它工种中比job_id为‘IT_PROG’工种任一工资低的员工的员工号、姓名、job_id以及salary
SELECT `employee_id` AS 员工号,CONCAT(`last_name`,' ',`first_name`) AS 员工姓名,`salary` AS 工资
FROM employees
WHERE `salary`<ANY(
    SELECT DISTINCT salary
    FROM employees
    WHERE job_id='IT_PROG'
) AND `job_id`!='IT_PROG';
#或
SELECT `employee_id` AS 员工号,CONCAT(`last_name`,' ',`first_name`) AS 员工姓名,`salary` AS 工资
FROM employees
WHERE `salary`<(
    SELECT MAX(salary)
    FROM employees
    WHERE job_id='IT_PROG'
) AND `job_id`!='IT_PROG';

#查询其它部门中比job_id为‘IT_PROG’部门所有工资都低的员工的员工号、姓名、job_id 以及salary
SELECT `employee_id` AS 员工号,CONCAT(`last_name`,' ',`first_name`) AS 员工姓名,`salary` AS 工资
FROM employees
WHERE `salary`<ALL(
    SELECT DISTINCT salary
    FROM employees
    WHERE job_id='IT_PROG'
) AND `job_id`!='IT_PROG';
#或
SELECT `employee_id` AS 员工号,CONCAT(`last_name`,' ',`first_name`) AS 员工姓名,`salary` AS 工资
FROM employees
WHERE `salary`<(
    SELECT MIN(salary)
    FROM employees
    WHERE job_id='IT_PROG'
) AND `job_id`!='IT_PROG';


#3、行子查询
#查询员工编号最小并且工资最高的员工信息
SELECT *
FROM employees
WHERE `employee_id`=(
    SELECT MIN(`employee_id`)
    FROM employees
) AND salary=(
    SELECT MAX(`salary`)
    FROM employees
);

SELECT *
FROM employees
WHERE (`employee_id`,`salary`)=(
    SELECT MIN(`employee_id`),MAX(`salary`)
    FROM employees
);



#二、select后面（仅支持标量子查询）
#查询每个部门的员工个数
SELECT d.*,(
    SELECT COUNT(*)
    FROM employees AS e
    WHERE e.`department_id`=d.`department_id`
) AS 员工个数
FROM departments AS d;

#查询员工号等于102的部门名
SELECT (
    SELECT `department_name`
    FROM departments AS d
    JOIN employees AS e
    ON e.`department_id`=d.`department_id`
    WHERE e.`employee_id`=102
) AS 部门名;



#三、from后面（必须起别名）
#查询每个部门的平均工资的工资等级
SELECT a.*,j.`grade_level` AS 工资等级
FROM (
    SELECT department_id AS 部门,AVG(salary) AS 平均工资
    FROM employees
    GROUP BY department_id
) AS a
JOIN `job_grades` AS j
ON a.平均工资 BETWEEN `lowest_sal` AND `highest_sal`;



#四、exists后面（相关子查询）
/*
    语法：exists(完整的查询语句)
    结果：1或0
*/
#查询有员工的部门名
#exist
SELECT department_name
FROM departments AS d
WHERE EXISTS(
    SELECT *
    FROM employees AS e
    WHERE d.`department_id`=e.`department_id`
);

#in
SELECT department_name
FROM departments AS d
WHERE d.`department_id` IN (
    SELECT DISTINCT department_id
    FROM employees
);