#进阶9：联合查询：将多条查询语句的结果合并成一个结果
/*
语法：
    查询语句1
    UNION
    查询语句2
    UNION
    查询语句3
应用场景：
    要查询的结果来自于多个表，且多个表之间没有直接的连接关系，但查询的信息一致
特点：
    ①要求多条查询语句的查询列数是一致的
    ②要求多条查询语句的查询的每一列的类型和顺序最好一致
    ③使用UNION关键字默认去重。如果想要想要包含重复项，使用UNION ALL
*/

#查询部门编号>90或邮箱中包含a的员工信息
#原方法
SELECT * FROM employees WHERE department_id>90 OR email LIKE '%a%';
#联合查询
SELECT * FROM employees WHERE department_id>90
UNION 
SELECT * FROM employees WHERE email LIKE '%a%';

