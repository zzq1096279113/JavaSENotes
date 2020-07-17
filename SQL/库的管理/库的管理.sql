#DDL：数据定义语言
/*
库和表的管理：
    一、库的管理：创建、修改、删除
    二、表的管理：创建、修改、删除

创建：create
修改：alter
删除：drop
*/

#一、库的管理
#1、库的创建：create datebase [if not exists] 库名;
CREATE DATABASE IF NOT EXISTS books;

#2、库的修改：
RENAME DATABASE books TO 新名字;

#更改库的字符集：utf-8 -->  gbk
ALTER DATABASE books CHARACTER SET gbk;

#3、库的删除：drop databasel if exists 库名;
DROP DATABASE IF EXISTS books;

