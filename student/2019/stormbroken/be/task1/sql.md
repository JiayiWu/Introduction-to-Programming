0. CREATE DATABASE `practice`
1. CREATE TABLE `practice`.`new_table` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `学生ID` INT NOT NULL,
  `课程ID` INT NOT NULL,
  `分数` INT NOT NULL,
  PRIMARY KEY (`ID`, `学生ID`, `分数`, `课程ID`));
2. INSERT INTO `practice`.`new_table` (`ID`, `学生ID`, `课程ID`, `分数`) VALUES ('1', '1', '1', '99');
3. UPDATE `practice`.`new_table` SET `ID` = '1', `学生ID` = '1', `课程ID` = '1', `分数` = '100' WHERE (`ID` = '1') and (`学生ID` = '1') and (`分数` = '99') and (`课程ID` = '1');
4. DELETE FROM `practice`.`new_table` WHERE (`ID` = '1') and (`学生ID` = '1') and (`分数` = '99') and (`课程ID` = '1');
5. SELECT *,MAX(score) FROM practice.score WHERE student_id = 1  
最高成绩为100
6. SELECT *,MIN(score) FROM practice.score WHERE student_id = 1
最低成绩为80
7. SELECT *,MAX(score) FROM practice.score group by course_id 
8. SELECT *,MAX(score) FROM practice.score group by course_id having count(course_id)>=2
9. SELECT *,avg(score) FROM practice.score group by course_id
10. select * from practice.score where student_id = 1 order by score DESC
11. select * from practice.score,practice.student where student_id = 1 and course_id = 1

### 索引练习
1. select * from practice.orders where age < 20
2. select * from practice.orders where name like '王%'
3. select count(*) from practice.orders where sex = '男'
4. select count(*) from practice.orders where sex = '女' and age > 50 and amount <100
5. select count(*) from practice.orders where char_length(name) = 3
6. select * from practice.products where nums > 150
