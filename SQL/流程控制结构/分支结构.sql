#流程控制结构
/*
顺序结构：程序从上到下依次执行
分支结构：程序从两条或多条路径中选择一条去执行
循环结构：程序在满足一定条件的基础上，重复执行一段代码

*/

#一、分支结构
#1、if函数
/*
功能：实现简单的双分支
    
语法：
    select if(表达式1,表达式2,表达式3)

执行顺序：
    如果表达式表达式1成立，则if函数返回表达式2的值，否则返回表达式3的值
    
应用：任何地方
*/

#2、case结构
/*
情况1： 类似于java中的swtich语句，一般用于实现等值判断
语法：
    case 变量 | 表达式 | 字段;
    when 要判断的值 then 返回的值1或语句1;
    when 要判断的值 then 返回的值2或语句2;
    else 返回的值n或语句n;
    end case;

情况2：类似于多重if语句，一般用于实现区间判断
语法：
    case
    when 要判断的条件1 then 返回的值1或语句1;
    when 要判断的条件2 then 返回的值2或语句2;
    else 返回的值n或语句n;
    end case;

特点：
    ①可以作为表达式，嵌套在其他语句中使用，可以放在任何地方使用
       可以作为独立的语句使用，只能放在begin end中
    ②如果when中的值或条件满足，则执行对应的then后面的语句，并结束case；
       如果都不满足则执行else中的语句或值。
    ③else可以省略，如果else省略了，并且所有when条件都不满足，则返回null
*/
#创建存储过程，根据传入的成绩，显示等级，如传入90-100显示A；80-90显示B；60-80显示D；否则显示D
CREATE PROCEDURE my_p1(IN score INT)
BEGIN 
    CASE
    WHEN score>90 AND score<=100 THEN SELECT 'A';
    WHEN score>80 AND score<=90 THEN SELECT 'B';
    WHEN score=>60 AND score<=80 THEN SELECT 'C';
    ELSE SELECT 'D';
    END CASE;
END$

#3、if结构
/*
功能：实现多重分支

语法：
    if 条件1 then 语句1;
    elseif 条件2 then 语句2;
    elseif 条件3 then 语句3;
    else 语句n;
    end if;

应用：应用在begin end中

*/
#创建存储过程，根据传入的成绩，返回等级，如传入90-100返回A；80-90返回B；60-80返回D；否则返回D
CREATE FUNCTION my_f7(score INT) RETURNS CHAR(1)
BEGIN
    IF score>90 AND score<=100 THEN RETURN 'A';
    ELSEIF score>80 AND score<=90 THEN RETURN 'B';
    ELSEIF score=>60 AND score<=80 THEN RETURN 'C';
    ELSE RETURN 'D';
    END IF;
END$

