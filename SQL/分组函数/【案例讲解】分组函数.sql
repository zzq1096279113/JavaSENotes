#1. 查询员工工资的最大值，最小值，平均值，总和 
SELECT MAX(`salary`) AS 最大值,MIN(`salary`) AS 最小值,ROUND(AVG(`salary`),2) 平均值,SUM(`salary`) AS 总和 FROM employees;

#2. 查询员工最高工资和最低工资的差距（DIFFERENCE） 
SELECT MAX(`salary`)-MIN(`salary`) AS DIFFERENCE FROM  employees;
SELECT DATEDIFF(MAX(`hiredate`),MIN(`hiredate`)) AS DIFFERENCE FROM  employees;

#3. 查询部门编号为90的员工个数
SELECT COUNT(*) FROM employees WHERE `department_id`=90;
