#二、循环结构
/*
分类：
    while，loop，repeat
    
循环控制：
    iterate类似于continue，结束本轮继续下一轮
    leave类似于break，结束当前所在循环

*/


#1.while
/*
语法：
    【标签】:while 循环条件 do
        循环体;
    end while 【标签】;
*/


#2.loop
/*
语法：
    【标签】:loop
        循环体;
    end loop 【标签】;
可以用来模拟简单的死循环
*/


#3.leave
/*
语法：
    【标签】:repeat
        循环体
        until 结束循环的条件
        end repeat 【标签】;
*/


#1、没有添加循环控制语句
#批量插入，根据次数插入到admin表中多条记录
CREATE PROCEDURE while_p1(IN insertCount INT)
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i<=insertCount DO
        INSERT INTO admin(`username`,`password`) VALUE (CONCAT('UZI',i),'777');
        SET i=i+1;
    END WHILE;
END$


#2、添加leave语句
#批量插入，根据次数插入到admin表中多条记录。如果次数大于20，则停止添加
CREATE PROCEDURE while_p2(IN insertCount INT)
BEGIN
    DECLARE i INT DEFAULT 1;
    a:WHILE i<=insertCount DO
        INSERT INTO admin(`username`,`password`) VALUE (CONCAT('Shy',i),'666');
        IF i>=20 THEN LEAVE a;
        END IF;
        SET i=i+1;
    END WHILE a;
END$


#2、添加iterate语句
#批量插入，根据次数插入到admin表中多条记录，直插入偶数次
CREATE PROCEDURE while_p3(IN insertCount INT)
BEGIN
    DECLARE i INT DEFAULT 0;
    WHILE i<=insertCount DO
        SET i=i+1;
        IF i%2!=0 THEN ITERATE a;
        END IF;
        INSERT INTO admin(`username`,`password`) VALUE (CONCAT('UZI',i),'777');
    END WHILE;
END$

