#变量
/*
系统变量：
    全局变量：
    会话变量：
    
自定义变量：
    用户变量：
    局部变量：
*/

#一、系统变量：变量由系统提供，不是用户定义，属于服务器层面
/*
1、查看所有的系统变量
SHOW GLOBAL | 【SESSION】 VARIABLES;
    
2、查看满足条件的部分系统变量
show GLOBAL | 【SESSION】 VARIABLES LIKE '';

3、查看满足条件的某个系统变量
select @@GLOBAL | 【SESSION】.系统变量名;

4、为某个系统变量赋值
方式一：
    set GLOBAL | 【SESSION】.系统变量名=值;
方式二：
    set @@GLOBAL | 【SESSION】.系统变量名=值;
    
注意：全局级别，则需要加global；
            会话级别，需要加session；
            如果不写，默认session。
*/

#1.1、全局变量
/*
作用域：服务器每次启动将为所有的全局变量赋予初始值，针对于所有的连接都有效，但是不能跨重启
*/
#①查看所有的全局变量
SHOW GLOBAL VARIABLES;

#②查看部分的全局变量
SHOW GLOBAL VARIABLES LIKE '%thread%';

#③查看指定的全局变量
SELECT @@global.autocommit;

#④为某个全局变量赋值
SET @@global.autocommit=0;

#1.2、会话变量
/*
作用域：仅仅针对于当前会话（连接）有效
*/
#①查看所有的会话变量
SHOW VARIABLES;

#②查看部分的会话变量
SHOW VARIABLES LIKE '%thread%';

#③查看指定的会话变量
SELECT @@autocommit;

#④为某个会话变量赋值
SET @@autocommit=0;
SET autocommit=0;


#二、自定义变量：用户定义的变量
/*
步骤：
    声明
    赋值
    使用
*/

#2.1、用户变量
/*
作用域：针对于当前会话（连接）有效

应用：应用在任何地方，begin end里面或begin end外面

①声明并初始化
    SET @用户变量名=值;
    SET @用户变量名:=值;
    SELECT @用户变量名:=值;

②赋值
方式一：通过set或select
    SET @用户变量名=值;
    SET @用户变量名:=值;
    SELECT @用户变量名:=值;
方式二：通过select into
    SELECT 字段 INTO 变量名
    FROM 表;

③使用
    SELECT @用户变量名;
*/
SELECT @count=1;
SELECT COUNT(*) INTO @count FROM employees;
SELECT @count;

#2.2、局部变量
/*
作用域：仅仅在定义它在begin end中有效

应用：应用在begin end中的第一句话

①声明
    DECLARE 变量名 类型;
    DECLARE 变量名 类型 DEFAULT 值;
    
②赋值
方式一：通过set或select
    SET 局部变量名=值;
    SET 局部变量名:=值;
    SELECT @局部变量名:=值;
方式二：通过select into
    SELECT 字段 INTO 局部变量名
    FROM 表;

③使用
    SELECT局部变量名;
    
对比：                 作用域             定义和使用的位置                语法                              限定类型
    用户变量         当前的会话      会话中的任何地方            必须加@                            不需要
    局部变量         begin end中     begin end的第一句话      一般不用加@符号             需要
*/
#1、用户变量
SET @m=1;
SET @n=2;
SET @sum=@m+@n;
SELECT @sum;

#2、局部变量
DECLARE a INT DEFAULT 1;
DECLARE b INT DEFAULT 2;

