-- 0.创建名为practice的数据库  
create database practice;  

use practice;  


-- 1.创建学生表，该表属性有ID（要求利用数据库自增长，主键）、学生ID、课程ID、分数  
create table students(
ID int primary key auto_increment,
student_ID int,
course_ID int,
grades int
);  

-- 2.向表中插入一条学生ID为1、课程ID为1、分数为99的信息  
insert into students values(null,1,1,99);  

-- 3.更改数据中学生ID为1，课程ID为1的成绩，把分数从99改成100  
update students set grades=100 where course_ID=1;  

-- 4.删除学生ID为1，课程ID为1的成绩  
delete from students where student_ID=1 and course_ID=1;  

-- 导入sql文件  
\source D:/prac.sql;   

-- 5.查找学生ID为1的学生最高成绩（使用max函数） 
select id,max(score) from score where student_id=1;

-- 6.查找学生ID为1的学生最低成绩（使用min函数） 
select id,min(score) from score where student_id=1;

-- 7.找出各门课程的最高成绩（使用max/groupBy函数） 
select course_id,max(score) from score group by(course_id);  

-- 8.找出各门课程的最高成绩,如果这门课程参与人数少于2人，则不参与统计（使用max/groupBy/having/count函数） 
select course_id,max(score) from score group by(course_id) having count(student_id)>=2;  

-- 9.找出各门课程的平均成绩（使用avg/groupBy函数）  
select course_id,avg(score) from score group by course_id;  

-- 10.查找学生ID为1学生的所有成绩，成绩按从高往低显示  
select student_id,score,course_id from score where student_id=1 order by score desc;  

-- 11.查找学生ID为1并且课程ID为1的姓名和成绩（使用score和student两张表联合查询，观察两个表结构）  
select student_id,course_id,name,score from score
join
student on student_id=student.id
where student_id=1 and course_id=1;  

索引练习  
-- 问题1:在 orders 表中找出购买人年龄小于20岁的order列表。   
select * from orders where age<20;  
<img src='Q1\Q1_01.png'>  

explain select * from orders where age<20;  
<img src='Q1\Q1_02.png'>  

-- 增加age索引前后type都是ALL，都是using where，时间相近，索引失效，不能优化，可能是优化器放弃从索引中读取而改为进行全表扫描  
create index index_age on orders(age);  
select * from orders where age<20;  
<img src='Q1\Q1_03.png'> 

explain select * from orders where age<20;  
<img src='Q1\Q1_04.png'>  

  
  
  
-- 问题2:在 orders 表中找出所有姓王的人的order列表。  
select * from orders where name like '王%';  
<img src='Q2\Q2_1.png'> 

explain select * from orders where name like '王%';  
<img src='Q2\Q2_2.png'> 

-- 优化  
create index index_name on orders(name);  
select * from orders where name like '王%';  
<img src='Q2\Q2_3.png'>  

explain select * from orders where name like '王%';  
<img src='Q2\Q2_4.png'>  


-- 问题3:统计 orders 表中所有男性的人的数量。  
explain select count(id) from orders where sex='男';  
--不能优化，性别字段唯一性差，不适合建立索引。   

-- 问题4:在 orders 表中计算女性,姓张,年龄大于50,且消费小于100的人数。  
select count(*) from orders where sex='女' and age>50 and amount<100 and name like '张%';  
explain select count(*) from orders where sex='女' and age>50 and amount<100 and name like '张%';  
<img src='Q4\Q4_1.png'>  

-- 尝试优化，效果不变，前面是count，后面age和amount都是范围，age和amount的索引失效
create index idx_name_age on orders(name,age);  
explain select count(*) from orders where sex='女' and age>50 and amount<100 and name like '张%';  
<img src='Q4\Q4_2.png'>  


-- 问题5:统计 orders 表中姓名为三个字的人数。  
select count(*) from orders where name like '___';  
explain select count(*) from orders where name like '___';  
<img src='Q5\Q5_1.png'>  
<img src='Q5\Q5_3.png'>  

-- 已用上前面建立的name索引进行优化，删除索引后效率降低  
<img src='Q5\Q5_2.png'>  
<img src='Q5\Q5_4.png'>  


-- 问题6:在 products 表中查找库存大于150的product列表。  
select * from products where nums>150;  
explain select * from products where nums>150;  
<img src='Q6\Q6_1.png'>  

-- 优化  
create index index_nums on products(nums);  
explain select * from products where nums>150;  
<img src='Q6\Q6_2.png'>  
