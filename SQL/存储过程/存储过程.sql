#存储过程和函数：类似于java中的方法
/*
好处：
    ①提高代码的重用性
    ②简化了操作


*/

#存储过程：一组预先编译好的SQL语句的集合，可以理解成批处理语句
/*
①提高代码的重用性
②简化了操作
③减少了编译次数，并减少了和数据库连接次数
*/

#一、创建语法
/*
语法：
    create procedure 存储过程名(参数列表)
    begin
        存储过程体（一组合法的SQL语句）
    end

注意：
    ①参数列表包含：参数模式 参数名 参数类型
        参数类型：
            in：该参数可以作为输入，需要调用方传入值
            out：该参数可以作为输出，可以作为返回值
            inout：该参数既可以作为输入也可以作为输出，既需要传入值也可以返回值
    ②如果存储过程只有一句话，begin end可以省略
    ③存储过程体中的每条SQL语句结尾要求必须加分号；
       存储过程的结尾可以用delimiter重新设置
*/


#二、调用语法
/*
语法：
    call 存储过程名 (实参列表);
*/


#1.空参列表
#插入五条记录到admin表中
DELIMITER $
CREATE PROCEDURE my_p1()
BEGIN
    INSERT INTO admin(`username`,`password`) VALUE ('Tom','12345'),('Rose','12345'),('Jerry','12345'),('Marry','12345'),('Jack','12345');
END$
#调用：
CALL my_p1()$


#2.带in模式参数的存储过程
#根据女神名，查询对应的男神信息
CREATE PROCEDURE my_p2(IN beautyName VARCHAR(15))
BEGIN
    SELECT b.* 
    FROM beauty AS g 
    LEFT JOIN boys AS b 
    ON g.`boyfriend_id`=b.`id`
    WHERE g.`name`=beautyName;
END$
#调用：
CALL my_p2('周冬雨')$

#用户是否登录成功
CREATE PROCEDURE my_p3(IN userName VARCHAR(20),IN PASSWORD VARCHAR(20))
BEGIN
    DECLARE result INT DEFAULT 0;
    SELECT COUNT(*) INTO result
    FROM admin AS a
    WHERE a.`username`=userName
    AND a.`password`=PASSWORD;
    SELECT IF(result>0,'成功','失败') AS 结果;
END$
#调用：
CALL my_p3('Jack','12345')$


#3.带out模式参数的存储过程
#根据女神名，返回对应的男神名
CREATE PROCEDURE my_p4(IN beautyName VARCHAR(10),OUT boyName VARCHAR(10))
BEGIN
    SELECT b.`boyName` INTO boyName
    FROM beauty AS g 
    LEFT JOIN boys AS b 
    ON g.`boyfriend_id`=b.`id`
    WHERE g.`name`=beautyName;
END$
#调用：
CALL my_p4('周芷若',@boyName)$

#根据女神名，返回对应的男神信息
CREATE PROCEDURE my_p5(IN beautyName VARCHAR(10),OUT boyName VARCHAR(10),OUT userCP INT)
BEGIN
    SELECT b.`boyName`,b.`userCP` INTO boyName,userCP
    FROM beauty AS g 
    LEFT JOIN boys AS b 
    ON g.`boyfriend_id`=b.`id`
    WHERE g.`name`=beautyName;
END$
#调用：
CALL my_p5('周芷若',@boyName,@userCP)$


#4.带inout模式参数的存储过程
#传入a和b的值，a和b的翻倍并返回
CREATE PROCEDURE my_p6(INOUT a INT,INOUT b INT)
BEGIN
    SET a=a*2;
    SET b=b*2;
END$
#调用：
SET @m=20$
SET @n=10$
CALL my_p6(@m,@n)$


#三、删除语法
/*
语法：
    drop procedure 存储过程名
*/
DROP PROCEDURE my_p1$


#四、查看存储过程的信息
SHOW CREATE PROCEDURE my_p3;

