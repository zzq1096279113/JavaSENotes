#1.查询每个专业的学生人数
SELECT majorid AS 专业,COUNT(*)
FROM student
GROUP BY majorid;


#2.查询参加考试的学生中，每个学生的平均分、最高分
SELECT `studentno`,AVG(`score`) AS 平均分,MAX(`score`) AS 最高分
FROM result
GROUP BY studentno;


#3.查询姓张的每个学生的最低分大于60的学号、姓名
SELECT s.`studentno` AS 学号,s.`studentname` AS 姓名
FROM student AS s
JOIN result AS r
ON s.`studentno`=r.`studentno`
WHERE s.`studentname` LIKE '张%'
GROUP BY s.`studentno`
HAVING MIN(r.`score`)>60;


#4.查询生日在‘1988-1-1’后的学生姓名、专业名称
SELECT studentname AS 学生姓名,majorname AS 专业名称
FROM student AS s
JOIN major AS m
ON s.`majorid`=m.`majorid`
WHERE DATEDIFF(borndate,'1988-1-1')>0;


#5.查询每个专业的男生人数和女生人数分别是多少
#方式一：
SELECT majorid AS 专业,sex AS 性别,COUNT(*)  AS 人数
FROM student
GROUP BY majorid,sex;
#方式二：
SELECT majorid AS 专业,
(SELECT COUNT(*) FROM student WHERE sex='男' AND majorid=s.`majorid`) AS 男,
(SELECT COUNT(*) FROM student WHERE sex='女' AND majorid=s.`majorid`) AS 女
FROM student AS s
GROUP BY majorid;


#6.查询专业和张翠山一样的学生的最低分
SELECT MIN(score) AS 最低分
FROM result
WHERE studentno IN (
    SELECT studentno
    FROM student
    WHERE majorid=(
        SELECT majorid
        FROM student
        WHERE studentname='张翠山'
    )
);


#7.查询大于60分的学生的姓名、密码、专业名
SELECT `studentname` AS 姓名,`loginpwd` AS 密码,`majorname` AS 专业名
FROM student AS s
JOIN major AS m ON s.`majorid`=m.`majorid`
JOIN result AS r ON s.`studentno`=r.`studentno`
WHERE score>60;


#8.按邮箱位数分组，查询每组的学生个数
SELECT LENGTH(email) AS 长度,COUNT(*) AS 学生个数
FROM student
GROUP BY LENGTH(email);


#9.查询学生名、专业名、分数
SELECT `studentname` AS 姓名,`majorname` AS 专业名,`score` AS 分数
FROM student AS s
JOIN major AS m ON s.`majorid`=m.`majorid`
JOIN result AS r ON s.`studentno`=r.`studentno`;


#10.查询哪个专业没有学生
SELECT m.`majorid`,`majorname`
FROM major AS m
LEFT JOIN student AS s
ON m.`majorid`=s.`majorid`
WHERE majorname IS NULL;


#11.查询没有成绩的学生人数
SELECT COUNT(*) AS 学生人数
FROM student AS s
LEFT JOIN result AS r
ON s.`studentno`=r.`studentno`
WHERE score IS NULL;

