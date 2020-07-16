 #1. 查询工资最低的员工信息：last_name,salary
SELECT last_name,salary
FROM employees
WHERE salary=(
   SELECT MIN(salary)
   FROM employees
);
 
 
#2. 查询平均工资最低的部门信息
#方式一：
SELECT *
FROM departments
WHERE department_id=(
    SELECT department_id
    FROM employees
    GROUP BY department_id
    HAVING AVG(salary)=(
        SELECT MIN(平均工资)
        FROM (
            SELECT AVG(salary) AS 平均工资
            FROM employees
            GROUP BY department_id
        ) AS avg_salary
    )
);
#方式二：
SELECT *
FROM departments
WHERE department_id=(
    SELECT department_id
    FROM employees
    GROUP BY department_id
    ORDER BY AVG(salary)
    LIMIT 1
);

 
#3. 查询平均工资最低的部门信息和该部门的平均工资  
SELECT d.*,平均工资
FROM departments AS d
JOIN (
    SELECT AVG(salary) AS 平均工资,department_id
    FROM employees
    GROUP BY department_id
    ORDER BY AVG(salary)
    LIMIT 1
) AS avg_salary
ON avg_salary.department_id=d.`department_id`;


#4. 查询平均工资最高的job信息
SELECT *
FROM jobs
WHERE `job_id`=(
    SELECT `job_id`
    FROM employees
    GROUP BY `job_id`
    ORDER BY AVG(salary) DESC
     LIMIT 1
);


#5. 查询平均工资高于公司平均工资的部门有哪些? 
SELECT department_id,AVG(salary) AS 平均工资
FROM employees
GROUP BY `department_id`
HAVING AVG(salary)>(
    SELECT AVG(salary)
    FROM employees
);


#6. 查询出公司中所有 manager 的详细信息.  
SELECT *
FROM employees
WHERE employee_id IN (
    SELECT DISTINCT manager_id
    FROM employees
);


#7. 各个部门中最高工资中最低的那个部门的最低工资是多少
SELECT department_id,MAX(salary)
FROM employees
GROUP BY department_id
ORDER BY MAX(salary) ASC
LIMIT 1;


#8. 查询平均工资最高的部门的manager的详细信息: last_name, department_id, email, salary
SELECT last_name, d.`department_id`, email, salary
FROM employees AS e
JOIN departments AS d
ON e.`employee_id`=d.`manager_id`
WHERE d.department_id=(
    SELECT department_id
    FROM employees
    GROUP BY department_id
    ORDER BY AVG(salary) DESC
    LIMIT 1
);

 