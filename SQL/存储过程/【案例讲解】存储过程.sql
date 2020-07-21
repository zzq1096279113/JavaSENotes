#1、创建存储过程或函数实现传入用户名和密码，插入到admin表中
CREATE PROCEDURE my_p7(IN loginName VARCHAR(20),IN loginPassword VARCHAR(20))
BEGIN 
    INSERT INTO admin(username,PASSWORD) 
    VALUE (loginName,loginPassword);
END$


#2、创建存储过程或函数实现传入女神编号，返回女神名称和女神电话
CREATE PROCEDURE my_p8(IN beautyId INT,OUT beautyName VARCHAR(10),OUT beautyPhone VARCHAR(20))
BEGIN
    SELECT `name`,`phone` INTO beautyName,beautyPhone
    FROM beauty
    WHERE id=beautyId;
END$


#3、创建存储存储过程或函数实现传入两个女神生日，返回大小
CREATE PROCEDURE my_p9(IN borndate1 DATETIME,IN borndate2 DATETIME,OUT result INT)
BEGIN
    SELECT DATEDIFF(borndate1,borndate2) INTO result;
END$


#4、创建存储过程或函数实现传入一个日期，格式化成 xx 年 xx 月 xx 日并返回
CREATE PROCEDURE my_p10(IN myDate DATETIME,OUT strDate VARCHAR(20))
BEGIN
    SELECT DATE_FORMAT(myDate,'%y年%m月%d日') INTO strDate;

END$


#5、创建存储过程或函数实现传入女神名称，返回：女神 and 男神格式的字符串
#如传入 ：小昭 
#返回：小昭 and 张无忌 
CREATE PROCEDURE my_p11(IN beautyName VARCHAR(20),OUT str VARCHAR(30))
BEGIN 
    SELECT CONCAT(g.name,' and ',IFNULL(b.boyName,'NULL')) INTO str
    FROM beauty AS g
    LEFT JOIN boys ON g.`boyfriend_id`=b.`id`
    WHERE g.name=beautyName;
END$


#6、创建存储过程或函数，根据传入的条目数和起始索引，查询beauty表的记录
CREATE PROCEDURE my_p12(IN startIndex INT,IN size INT)
BEGIN
    SELECT *
    FROM beauty
    LIMIT startIndex,size;
END$

