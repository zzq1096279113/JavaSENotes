#1.创建book表
CREATE TABLE book(
    bid INT PRIMARY KEY,
    bname VARCHAR(20) UNIQUE NOT NULL,
    price FLOAT DEFAULT 10,
    btypeId INT,
    FOREIGN KEY (btypeId) REFERENCES bookType(id)
);


#2.开启事务，向表中插入一行数据，结束事务
SET autocommit=0;
INSERT INTO book VALUE (1,'老人与海',53,5);
COMMIT;


#3.创建视图，实现查询价格大于100的书名和类型名
CREATE OR REPLACE VIEW book_v1
AS
SELECT bname AS 书名,NAME AS 类型名
FROM book AS b
JOIN bookType AS t ON b.btypeId=t.id
WHERE price>100;


#4.修改视图，实现查询价格在90-120之间的书名和价格
CREATE OR REPLACE VIEW book_v1
AS
SELECT bname AS 书名,price AS 价格
FROM book
WHERE price BETWEEN 90 AND 120;


#5.删除刚才新建的视图
DROP VIEW book_v1

