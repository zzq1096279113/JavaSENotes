#TCL：Transaction Control Language 事务控制语言
/*
事务：
    一个或一组sql语句组成一个执行单元，这个执行单元要么全部执行，要么全部不执行

特性：
    ①原子性（Atomicity）：指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生；
    ②一致性（Consistency）：事务必须使数据库从一个一致性状态变换到另外一个一致性状态；
    ③隔离性（Isolation）：指一个事务的执行不能被其他事务干扰；
    ④持久性（Durability）：指一个事务一旦被提交，则会永久性改变数据库中的数据。

创建：
    隐式事务：事务没有明显的开启和结束标记
    显式事务：事务具有明显的开启和结束标记
        前提：必须设置自动提交功能为禁用
        
步骤：
    ①开启事务：set autocommit=0;
    ②编写事务中的sql语句(select,insert,delete,update)：语句1;语句2;...
    ③结束事务：commit提交事务；rollback回滚事务

并发问题：
    脏读：对于两个事务T1,T2。T1读取了已经被T2更新但还没有被提交的字段。之后, 若T2回滚,T1读取的内容就是临时且无效的。
    不可重复读：对于两个事务T1,T2。T1读取了一个字段, 然后T2 更新了该字段。之后,T1再次读取同一个字段, 值就不同了。
    幻读：对于两个事务T1,T2。T1 从一个表中读取了一个字段, 然后T2在该表中插入了一些新的行。之后, 如果T1再次读取同一个表, 就会多出几行。

事务隔离级别：
                                                脏读      不可重复读       幻读
    read  uncommitted               √               √                   √
    read  committed                   ×               √                   √ 
    repeatable read（默认）   ×                ×                   √
    serializable                           ×                ×                   ×

查看隔离级别：
    select @@tx_isolation;
    
设置隔离级别：
    set session | global transaction isolation level 隔离级别;
*/

SHOW VARIABLES LIKE 'autocommit';
SET autocommit=0;#关闭自动提交

#开启事务
SET autocommit=0;
#编写一组sql语句
UPDATE account SET balance=1000 WHERE   username='张无忌';
UPDATE account SET balance=1000 WHERE   username='赵敏';
#结束事务
ROLLBACK;

SELECT * FROM account;

