#三、删除语句
/*
语法：
    方式一：
        delete from 表名 where 筛选条件;
    方式二：
        truncate table 表名;
特点：
    ①delete可以加where条件，truncate不能
    ②truncate删除效率高一点点
    ③如果删除表中有自增长列，delete删除后再插入数据，自增长列的值从断点开始；
                                                       truncate删除 后再插入数据，自增长列的值从1开始。
    ④truncate删除没有返回值，delete删除有返回值
    ⑤truncate删除不能回滚，delete删除可以回滚
*/

#1.单表的删除
#删除手机尾号为9的女神信息
DELETE FROM beauty WHERE phone LIKE '%9';


#2.多表的删除
#删除张无忌的女朋友信息
DELETE g FROM beauty AS g
JOIN boys AS b
ON b.`id`=g.`boyfriend_id`
WHERE b.`boyName`='张无忌';

#删除黄晓明以及其女朋友的信息
DELETE b,g
FROM beauty AS g
JOIN boys AS b
ON g.`boyfriend_id`=b.`id`
WHERE b.`boyName`='黄晓明';
