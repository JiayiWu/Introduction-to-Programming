0.
CREATE DATABASE practice;

1.
CREATE TABLE INFO VALUES (stuID int, courseID int,score int);

2.
INSERT INTO INFO (stuID, courseID, score) VALUES (1,1,99);

3.
UPDATE INFO SET score=1 WHERE stuID=1 AND courseID=1;

4.
DELETE FROM INFO WHERE stuID=1 AND courseID=1;

5.
SELECT MAX(score) FROM score where student_id=1;

6.
SELECT MIN(score) FROM score WHERE student_id=1;

7.
SELECT course_id, MAX(score) FROM score GROUP BY course_id;

8.
SELECT id,course_id,MAX(score) FROM score GROUP BY course_id HAVING COUNT(student_id)>1;

9.
SELECT course_id,AVG(score) FROM score GROUP BY course_id;

10.
SELECT course_id,score FROM score WHERE student_id=1 ORDER BY score DESC;

11.
SELECT stu.name,sco.score FROM score sco INNER JOIN student stu ON sco.id=stu.id WHERE sco.id=1 AND sco.course_id=1;

1.
可以建立索引
ALTER TABLE orders ADD INDEX age_index(age);
查询：
SELECT * FROM orders FORCE INDEX(age_index) WHERE age<=20;
时间对比：
不建立索引时时间更短，可能是因为数据太大，所以建立索引消费的时间更多

2.
可以建立索引
ALTER TABLE orders ADD INDEX name_index(name);
时间对比：
添加了索引后时间变长了，可能是因为要查询的东西占文件的较大部分

3.
可以建立索引
ALTER TABLE orders ADD INDEX sex_index(sex);
时间对比：
加入索引后时间大幅变短

4.
可以建立索引
ALTER TABLE orders ADD INDEX sex_name_age_amount_index(sex,name,age,amount);
时间对比：
可以用name_index或者sex_name_age_amount_index，但是用前者的效率更高，可能是因为用like匹配的时候效率更低

5.
可以建立索引
用name_index效率更高

6.
可以建立索引
ALTER TABLE orders ADD nums_index(nums);
时间对比：
用了索引后时间大幅缩短
