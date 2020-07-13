#1、查询编号>3 的女神的男朋友信息，如果有则列出详细，如果没有，用 null 填充 
SELECT b.`id` AS id,b.`name` AS 女神,boy.*
FROM beauty AS b
LEFT JOIN boys AS boy
ON b.`boyfriend_id`=boy.`id`
WHERE b.`id`>3;

#2、查询哪个城市没有部门 
SELECT `city` AS 城市,d.`department_name` AS 部门 
FROM locations AS l
LEFT JOIN departments AS d
ON l.`location_id`=d.`location_id`
WHERE `department_id` IS NULL;

#3、查询部门名为 SAL 或 IT 的员工信息
SELECT e.*,`department_name` AS 部门名
FROM departments AS d
LEFT JOIN employees AS e
ON e.`department_id`=d.`department_id`
WHERE department_name IN ('SAL','IT')
