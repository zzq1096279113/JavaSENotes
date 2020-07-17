#二、修改语句
/*
语法：
    ①修改单表记录★
        update 表名
        set 列=新值,列=新值,...
        where 筛选条件;
    ②修改多表记录
        sql92语法：
            update 表1 别名，表2 别名
            set 列=新值,列=新值,...
            where 连接条件
            and 筛选条件;
        sql99语法：
            update 表1 别名
            left | right join 表2 别名
            on 连接条件
            set 列=新值,列=新值,...
            where 筛选条件;
*/

#1.修改单表的记录
#修改beauty表中姓“乐”的女神的电话为13899888899
UPDATE beauty SET phone='13899888899'
WHERE NAME LIKE '乐%';

#修改boys表中的id=2名称为张飞，魅力值为200
UPDATE boys SET boyName='张飞',userCP=200
WHERE id=2;


#2.修改多表的记录
#修改张无忌的女朋友的手机号为12358
UPDATE beauty AS g
JOIN boys AS b
ON g.`boyfriend_id`=b.`id`
SET g.phone='12358'
WHERE b.boyName='张无忌';

#修改没有男朋友的女神的男朋友编号都为张飞
UPDATE beauty AS g
LEFT JOIN boys AS b
ON g.`boyfriend_id`=b.`id`
SET g.`boyfriend_id`=2
WHERE b.`id` IS NULL;

