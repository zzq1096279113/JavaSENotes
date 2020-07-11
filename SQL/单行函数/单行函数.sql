#进阶4：常见函数
/*
功能：类似于java中的方法，将一组逻辑语句封装在方法体中，对外暴露方法名
            ①隐藏了实现细节②提高了代码的重用性
调用：select 函数名(实参列表) [form 表];
特点：函数名，函数的功能
分类：单行函数：concat、length、ifnull
            分组函数：做统计使用。又称为统计函数、聚合函数、组函数
            
常见函数：字符函数：length、concat、substr、instr、trim、upper、lower、lpad、rpad
                    数学函数：round、ceil、floor、truncate、mod
                    日期函数：now、curdate、curtime、year、month、monthname、day、str_to_date、date_format
                    其他函数：version、database、user
                    控制函数：if、case
*/

#一、字符函数
#1.length：获取参数值的字节个数
SELECT LENGTH('John');

#2.concat：拼接字符串
SELECT CONCAT(`last_name`,'_',`first_name`) AS 姓名 FROM employees;

#3.upper、lower：大小写转换
SELECT  UPPER('john');
#姓变大写，名变小写
SELECT CONCAT(UPPER(`last_name`),' ',LOWER(`first_name`)) AS 姓名 FROM employees;

#4.substr、substring：截取字符（索引从1开始）
SELECT SUBSTR('蔡徐坤打篮球',5) AS ball;#截取指定索引后面所有字符
SELECT SUBSTR('蔡徐坤打篮球',1,3) AS people;#截取指定索引后面指定长度的字符
#姓名中首字符大写，其他字符小写然后用_拼接显示出来
SELECT CONCAT(UPPER(SUBSTR(`last_name`,1,1)),'_',LOWER(SUBSTR(`last_name`,2))) AS 名字 FROM employees;

#5.instr：返回子串第一次出现的索引，如果找到不到返回0。
SELECT INSTR('微博热搜停更一周','热搜') AS out_put;

#6.trim：去空格
SELECT TRIM('   星期三     ') AS out_put;
SELECT TRIM('3' FROM '3333333333星期三333333333') AS out_put;

#7.lpad：用指定的字符实现左填充到指定长度
#   rpad：用指定的字符实现右填充到指定长度
SELECT LPAD('313',10,'*') AS out_put;
SELECT RPAD('313',10,'*') AS out_put;

#replace：替换
SELECT REPLACE('指定长度指定位置','指定','随机') AS out_put;


#二、数学函数
#1.round：四舍五入[第二个参数表示保留小数点后几位]
SELECT ROUND(1.65) AS out_put;
SELECT ROUND(1.65,1) AS out_put;

#2.ceil：向上取整，返回≥该参数的最小整数
SELECT CEIL(1.1) AS out_put;
SELECT CEIL(-1.1) AS out_put;

#3.floor：向下取整，返回≤该参数的最小整数
SELECT FLOOR(9.9) AS out_put;
SELECT FLOOR(-9.9) AS out_put;

#4.truncate：截断
SELECT TRUNCATE(1.65,1) AS out_put;

#5.mod：取模
SELECT MOD(10,3);


#三、日期函数
#1.now()：返回当前日期+时间
SELECT NOW();

#2.curdate()：返回当前日期
SELECT CURDATE();

#3.curtime()：返回当前时间
SELECT CURTIME();

#4.定向的获取年、月、日、时、分、秒。
SELECT YEAR(NOW()) AS 年;
SELECT MONTH('1999-8-23') AS 月;
SELECT MONTHNAME('1999-8-23') AS 月;
SELECT DAY(hiredate) AS 日 FROM employees;

#5.str_to_date：将日期格式的字符转换成指定格式的日期
SELECT STR_TO_DATE('1998-3-2','%Y-%d-%c') AS out_put;

#6.date_format：将日期转换成字符
SELECT DATE_FORMAT(NOW(),'%Y年%c月%d日') AS out_put;
#查询有奖金的员工名和入职日期
SELECT CONCAT(`last_name`,'_',`first_name`) AS 姓名,DATE_FORMAT(hiredate,'%Y年%c月%d日') AS 入职日期 FROM employees WHERE commission_pct IS NOT NULL;


#四、其他函数
SELECT VERSION();#查看当前数据库版本号
SELECT DATABASE();#查看当前所在表
SELECT USER();#查看当前用户


#五、流程控制函数
#1.if函数：if else的效果
SELECT IF(10>5,'大','小') AS out_put;
SELECT CONCAT(`last_name`,'_',`first_name`) AS 姓名,IF(commission_pct IS NULL,'没奖金','有奖金') AS 备注 FROM employees;

#2.case函数：
/*switch case的效果
case  要判断的字段或表达式
when 常量1 then 要显示的值1或语句1
when 常量2 then 要显示的值2或语句2
...
else 要显示的值n或语句n
end
*/
/*
查询员工的工资，要求为
部门号=30，显示工资为1.1倍
部门号=40，显示工资为1.2倍
部门号=50，显示工资为1.3倍
其他部门，显示原工资
*/
SELECT salary AS 原工资,department_id AS 部门号,
CASE department_id
WHEN 30 THEN salary*1.1
WHEN 40 THEN salary*1.2
WHEN 50 THEN salary*1.3
ELSE salary
END AS 新工资
FROM employees;

/*if else的效果
case
when 条件1 then 要显示的值1或语句1
when 条件2 then 要显示的值2或语句2
...
else 要显示的值n或语句n
end
*/
/*
查询员工的工资情况
如果工资>20000，显示A级别
如果工资>15000，显示B级别
如果工资>10000，显示C级别
否则，显示A级别    
*/
SELECT salary AS 工资,
CASE
WHEN salary>20000 THEN 'A'
WHEN salary>15000 THEN 'B'
WHEN salary>10000 THEN 'C'
ELSE 'D'
END AS 工资级别
FROM employees;




