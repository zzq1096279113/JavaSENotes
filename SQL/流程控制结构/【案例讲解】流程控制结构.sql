/*1、已知表 stringcontent 其中字段：
id 自增长
content varchar(20)
向该表插入指定个数的，随机的字符串 
*/
CREATE TABLE stringContent(
    id INT PRIMARY KEY AUTO_INCREMENT,
    content VARCHAR(20)
);

CREATE PROCEDURE test_p1(IN num INT)
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE str VARCHAR(26) DEFAULT 'abcdefghijklmnopqrstuvwxyz';
    DECLARE startIndex INT DEFAULT 1;
    DECLARE len INT DEFAULT 1;
    WHILE i<=num DO
        SET startIndex=FLOOR(RAND()*26+1);
        SET len=FLOOR(RAND()*(20-startIndex+1)+1);
        INSERT INTO stringContent(content) VALUE (SUBSTR(str,startIndex,len));
        seti=i+1;
    END WHILE;
END$

