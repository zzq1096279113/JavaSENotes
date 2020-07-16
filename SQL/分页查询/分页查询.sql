#进阶8：分页查询
/*
应用场景：查询的数据一页显示不全，需要分页提交sql请求
语法：select 查询列表
            from 表1
        【join type join 表2
            on 连接条件
            where 筛选条件
            group by 分组条件
            having 筛选条件
            order by 排序条件】
            limit offset,size;
            offset起始索引（从0开始）
            size要显示的条目个数
特点：①limit语句放在查询语句的最后
            ②页数page，每页条目数size
                select 查询列表
                from 表
                limit (page-1)*size,size
*/
#查询前五条员工信息
SELECT * 
FROM employees 
LIMIT 0,5;

#查询第11条到第25条员工信息
SELECT * 
FROM employees 
LIMIT 10,15;

#查询有奖金的员工信息，工资最高的10名显示出来
SELECT *
FROM employees
WHERE commission_pct IS NOT NULL
ORDER BY salary DESC
LIMIT 10;
