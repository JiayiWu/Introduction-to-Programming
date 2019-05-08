# 0
    create database practice;
# 1
    use practice;
    create table students(
                           id int primary key auto_increment,
                           student_id int,
                           course_id int,
                           score int
    );
# 2
    insert into students (student_id, course_id, score) values (1, 1, 99);
# 3
    update students set score = 100 where student_id = 1 and course_id = 1;
# 4
    delete from students where student_id=1 and course_id=1;
# 5
    select max(score) from score where student_id = 1;
# 6
    select min(score) from score where student_id = 1;
# 7
    select course_id, max(score) from score group by course_id;
# 8
    select course_id, max(score) from score group by course_id having count(student_id)>1 ;
# 9
    select course_id, avg(score) from score group by course_id;
# 10
    select course_id, score from score where student_id=1 order by score desc;
# 11
    select a.name, b.score from student a, score b where a.id=1 and b.student_id=1 and b.course_id=1;
# 超级抱歉，索引练习还是没有完成，这几天事情有点多。。。

