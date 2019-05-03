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