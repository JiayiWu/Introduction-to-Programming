### SQL
0.
mysql> create database practice;
1.
mysql> create table student (
  -> id int not null auto_increment,
  -> student_id varchar(9) not null,
  -> class_id varchar(11) not null,
  -> grade int not null,
  -> primary key(id)
  -> )charset=utf8;
2.
mysql> insert into student
  -> (student_id, class_id, grade)
  -> values
  -> ('1', '1', 99);
3.
mysql> update student set grade=100
  -> where student_id='1' and class_id='1';
4.
mysql> delete from student
  -> where student_id='1' and class_id='1';
### 函数练习
5.
mysql> select max(score) from score where student_id=1;
+------------+
| max(score) |
+------------+
|        100 |
+------------+
6.
mysql> select min(score) from score where student_id=1;
+------------+
| min(score) |
+------------+
|         80 |
+------------+
7.
mysql> select course_id, max(score) from score group by course_id order by max(score) desc;
+-----------+------------+
| course_id | max(score) |
+-----------+------------+
|         1 |        100 |
|         5 |         99 |
|         6 |         99 |
|         4 |         95 |
|         7 |         91 |
|         8 |         91 |
|         3 |         90 |
|         2 |         82 |
+-----------+------------+
8.
mysql> select course_id, max(score) from score group by course_id having count(*)>=2;
+-----------+------------+
| course_id | max(score) |
+-----------+------------+
|         1 |        100 |
|         2 |         82 |
|         3 |         90 |
|         4 |         95 |
|         5 |         99 |
|         6 |         99 |
+-----------+------------+
9.
mysql> select course_id,avg(score) from score group by course_id;
+-----------+------------+
| course_id | avg(score) |
+-----------+------------+
|         1 |    80.0833 |
|         2 |    81.0000 |
|         3 |    89.0000 |
|         4 |    95.0000 |
|         5 |    97.0000 |
|         6 |    93.5000 |
|         7 |    91.0000 |
|         8 |    91.0000 |
+-----------+------------+
10.
mysql> select student_id,score from score where student_id=1 order by score desc;
+------------+-------+
| student_id | score |
+------------+-------+
|          1 |   100 |
|          1 |    99 |
|          1 |    99 |
|          1 |    95 |
|          1 |    91 |
|          1 |    91 |
|          1 |    88 |
|          1 |    80 |
+------------+-------+
11.
mysql> select id from score where student_id=1 and course_id=1 union select id from student;
+----+
| id |
+----+
|  1 |
|  2 |
|  3 |
|  4 |
+----+
### 索引练习
1.
1.1 无索引：
mysql> select * from orders where age<20;
571196 rows in set (1.80 sec)

mysql> explain select * from orders where age<20\G
*************************** 1. row ***************************
id: 1
select_type: SIMPLE
table: orders
partitions: NULL
type: ALL
possible_keys: NULL
key: NULL
key_len: NULL
ref: NULL
rows: 4987586
filtered: 33.33
Extra: Using where
1 row in set, 1 warning (0.00 sec)

1.2 添加索引后：
mysql> create index age on orders(age);
mysql> select * from orders where age<20;
571196 rows in set (1.81 sec)

mysql> explain select * from orders where age<20\G
*************************** 1. row ***************************
id: 1
select_type: SIMPLE
table: orders
partitions: NULL
type: ALL
possible_keys: age
key: NULL
key_len: NULL
ref: NULL
rows: 4987586
filtered: 24.66
Extra: Using where
1 row in set, 1 warning (0.00 sec)

1.3 结论
由于数据分布，解释器选择不使用索引查询

2.
2.1 无索引：
mysql> select * from orders where name like '王%';
11160 rows in set (1.64 sec)

mysql> explain select * from orders where name like '王%'\G
*************************** 1. row ***************************
id: 1
select_type: SIMPLE
table: orders
partitions: NULL
type: ALL
possible_keys: NULL
key: NULL
key_len: NULL
ref: NULL
rows: 4987586
filtered: 11.11
Extra: Using where
1 row in set, 1 warning (0.00 sec)

2.2 添加索引后：
mysql> create index name on orders(name);
mysql> select * from orders where name like '王%';
11160 rows in set (0.25 sec)

mysql> explain select * from orders where name like '王%'\G
*************************** 1. row ***************************
id: 1
select_type: SIMPLE
table: orders
partitions: NULL
type: range
possible_keys: name
key: name
key_len: 302
ref: NULL
rows: 20582
filtered: 100.00
Extra: Using index condition; Using MRR
1 row in set, 1 warning (0.00 sec)

2.3 结论：
建立BTREE索引可提高where name like ‘王%’ 的查询效率

3.
3.1 无索引：
mysql> select * from orders where age='男';
2499997 rows in set (3.14 sec)

mysql> explain select * from orders where sex='男'\G
*************************** 1. row ***************************
id: 1
select_type: SIMPLE
table: orders
partitions: NULL
type: ALL
possible_keys: NULL
key: NULL
key_len: NULL
ref: NULL
rows: 4987586
filtered: 10.00
Extra: Using where
1 row in set, 1 warning (0.00 sec)

3.2 添加索引后：
mysql> create index sex on orders(sex);
mysql> select * from orders where age='男';
2499997 rows in set (43.24 sec)

mysql> explain select * from orders where sex='男'\G
*************************** 1. row ***************************
id: 1
select_type: SIMPLE
table: orders
partitions: NULL
type: ref
possible_keys: sex
key: sex
key_len: 767
ref: const
rows: 2493793
filtered: 100.00
Extra: NULL
1 row in set, 1 warning (0.00 sec)

3.3 结论：
对于值的变化少的列创建索引反而大大地降低了查询效率！

4.
4.1 无索引：
mysql> select count(*) from orders where sex='女' and name like '张%' and age>50 and amount<100;
+----------+
| count(*) |
+----------+
|      258 |
+----------+
1 row in set (1.64 sec)

mysql> explain select count(*) from orders where sex='女' and name like '张%' and age>50 and amount<100\G
*************************** 1. row ***************************
id: 1
select_type: SIMPLE
table: orders
partitions: NULL
type: ALL
possible_keys: NULL
key: NULL
key_len: NULL
ref: NULL
rows: 4987586
filtered: 0.12
Extra: Using where
1 row in set, 1 warning (0.00 sec)

4.2 添加索引后：
mysql> create index mul_index on orders(sex, name, age, amount);
mysql> select count(*) from orders where sex='女' and name like '张%' and age>50 and amount<100;
+----------+
| count(*) |
+----------+
|      258 |
+----------+
1 row in set (0.01 sec)

mysql> explain select count(*) from orders where sex='女' and name like '张%' and age>50 and amount<100\G
*************************** 1. row ***************************
id: 1
select_type: SIMPLE
table: orders
partitions: NULL
type: range
possible_keys: mul_index
key: mul_index
key_len: 1073
ref: NULL
rows: 10528
filtered: 11.11
Extra: Using where; Using index
1 row in set, 1 warning (0.00 sec)

4.3 结论
虽然使用运算符使得只有前两项索引发挥作用，但依旧显著的减少索引时间

5.
5.1 无索引：
mysql> select count(*) from orders where name like '___';
+----------+
| count(*) |
+----------+
|  2501252 |
+----------+
1 row in set (1.29 sec)

mysql> explain select count(*) from orders where name like '___'\G
*************************** 1. row ***************************
id: 1
select_type: SIMPLE
table: orders
partitions: NULL
type: ALL
possible_keys: NULL
key: NULL
key_len: NULL
ref: NULL
rows: 4987586
filtered: 11.11
Extra: Using where
1 row in set, 1 warning (0.00 sec)

5.2 添加索引后：
mysql> create index name on orders(name);
mysql> select count(*) from orders where name like '___';
+----------+
| count(*) |
+----------+
|  2501252 |
+----------+
1 row in set (1.16 sec)

mysql> explain select count(*) from orders where name like '___'\G
*************************** 1. row ***************************
id: 1
select_type: SIMPLE
table: orders
partitions: NULL
type: index
possible_keys: NULL
key: name
key_len: 302
ref: NULL
rows: 4987586
filtered: 11.11
Extra: Using where; Using index
1 row in set, 1 warning (0.00 sec)

5.3 结论：
添加索引略微提升查询效率，然而查询条件较不明确所以提升效果不大。

6.
6.1 无索引：
mysql> select * from products where nums>150;
2534 rows in set (0.00 sec)

mysql> explain select * from products where nums>150\G
*************************** 1. row ***************************
id: 1
select_type: SIMPLE
table: products
partitions: NULL
type: ALL
possible_keys: NULL
key: NULL
key_len: NULL
ref: NULL
rows: 10236
filtered: 33.33
Extra: Using where
1 row in set, 1 warning (0.00 sec)

6.2 添加索引后：
mysql> create index nums on products(nums);
mysql> select * from products where nums>150;
2534 rows in set (0.00 sec)

mysql> explain select * from products where nums>150\G
*************************** 1. row ***************************
id: 1
select_type: SIMPLE
table: products
partitions: NULL
type: range
possible_keys: nums
key: nums
key_len: 4
ref: NULL
rows: 2534
filtered: 100.00
Extra: Using index condition
1 row in set, 1 warning (0.00 sec)

6.3 结论：
有效。
