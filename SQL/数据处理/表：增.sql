#DML语言
/*
数据操作语言：
    插入：insert
    修改：update
    删除：delete

*/

#一、插入语句

#方式一：insert into 表名（列名,...） values （值1,...）
#1.插入的值的类型要与列的类型一致或兼容
INSERT INTO beauty(id,NAME,sex,borndate,phone,photo,boyfriend_id) 
VALUE (13,'妮寇','女','1999-1-1','18912349876',NULL,4);

#2.不可以为null的列必须插入值
#方式一：有列名，值为null
INSERT INTO beauty(id,NAME,sex,borndate,phone,photo,boyfriend_id) 
VALUE (13,'妮寇','女','1999-1-1','18912349876',NULL,4);
#方式二：没有列名，默认为null
INSERT INTO beauty(id,NAME,sex,borndate,phone,boyfriend_id) 
VALUE (14,'佐伊','女','1000-1-1','18912344566',6);

#3.列的顺序可以颠倒
INSERT INTO beauty(borndate,NAME,sex,id,phone,boyfriend_id) 
VALUE ('1998-1-1','乐芙兰','女',15,'18921344566',7);

#4.列数和值的个数必须一致
INSERT INTO beauty(borndate,NAME,sex,id,phone,boyfriend_id) 
VALUE ('1998-1-1','乐芙兰','女',16,'18921344566');

#5.可以省略列名，默认所有列。列的顺序与表中的顺序一致
INSERT INTO beauty
VALUE (16,'雷欧娜','女','1899-1-1','18913699876',NULL,8);

#6.支持插入多行
INSERT INTO beauty
VALUE (20,'雷欧娜','女','1899-1-1','18913699876',NULL,8),
(21,'妮寇','女','1999-1-1','18912349876',NULL,4),
(22,'乐芙兰','女','1998-1-1','18921344566',7);

#6.支持子查询
INSERT INTO beauty(id,NAME,phone)
SELECT 23,'凯特琳娜','18219753577';

#方式二：insert into 表名 set 列名=值,set 列名=值,...
INSERT INTO beauty
VALUE id=17,NAME='凯特琳娜',phone='18219753577';



