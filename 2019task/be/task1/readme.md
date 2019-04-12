### Java练习
**自己创建MD文件，代码所有都需要提交，思考题全部记录到prac.md文件中**

1.新建一个start类，创建一个main方法，java有八种基本数据类型，在main方法中新建，每一个基本数据类型变量并打印它的值。自己理解每个类型的长度，可表示的值的范围等信息。[提交代码]


2.新建一个Caculator类，创建一个main方法，定义两个int类型的变量a = 12 , b = 5，计算下列表达式的值：a+b，a-b ，a * b， a／b，a%b ，思考所得的值是否你想象的一样，定义int类型的变量c,计算并思考c=a++ ，c=++a之间的区别。尝试使用关系运算符 == ，!= > ，< ，>= ，<=。 [提交代码]

3.拓展Caculator扩展，要得到a*4的值，除了直接将a的值乘4还有什么办法，思考两种办法区别。[提交代码]

（以下题目自行新建类和main方法）
4.了解 while、do-while、for三种不同的循环的用法，使用三种方式计算1+2+3......+100 、1+3+5+ …+101的值。了解数组，新建一个基本类型变量的数组，使用循环语句遍历打印数组中的值。[提交代码]

5.了解条件语句if...else...语句，判断一个数的奇偶。思考，如何使用条件语句判断一个用int类型表示的年份是否是闰年。[提交代码]

6.思考，如何使用循环语句和条件语句来判断一个数是否为素数。[提交代码]


7. 使用if...else if...else，输入为10，20，30，40，50中的一个，如何判断他们的值。用switch优化多重的判断。[提交代码]

8.了解BufferredReader，使用BufferedReader从控制台读取输入。了解FileInputStream、FileOutputSteam， 读取文件、写文件。思考在读取文件的时候如果没有读到文件，会发生什么？连接Java 异常 try…catch机制。[提交代码和Readme.md文件]

9.通过控制台读取数据
 89 79 45 65 32 77 30 37 29 14
利用冒泡排序、选择排序，将以上整数按从大到小排列。[提交代码]

10.新建一个Practice类，类中建立三个名称为add的方法，返回值都为int类型，其中三个方法参数个数都不同。[提交prac.md文件]
具体伪代码如下图

```java
int add (int a,int b){
return a+b;
}

int add (int a,int b,int c){
return a+b+c;
}

int add (int a,int b,int c,int d){
return a+b+c+d;
}
```

同时参数个数保持相同，但返回值不同，具体伪代码如下图
```java
int add (int a,int b){
return a+b;
}

double add (int a,int b){
return a+b+1.0;
}

```
尝试上述两端代码是否可以编译，如果可以，请思考为什么可以。如果不可以，请阐述不可以原因。

10.新建一个Father类，同时自定义一个run方法。再新建一个Son类，继承Father类（使用extends字段），同时在该类中定义一个run方法。然后建立Main方法，并new Son类执行run方法，观察具体调用的是哪个run方法。[提交代码和prac.md文件]

11.新建Father类和Son类，并且Son类继承Father类，思考在new Son对象的时候对象初始化顺序，即只调用子类构造器还是先调用子类构造器再调用父类构造器亦或是顺序相反。建议自己想一个方法进行验证。[提交代码和prac.md文件]

12.自己实现以下代码，观察运行结果，并思考多态
Animal接口[提交prac.md文件]
```java
public interface Animal {
    public void eat();
}
```
Cat类
```java
public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("Cat eat");
    }
}
```
Dog类
```java
public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog eat");
    }
}
```
主程序运行类
```java
public class Practice {
    public static void main(){
        Animal animal = new Cat();
        //观察输出结果
        animal.eat();
        animal = new Dog();
        //观察输出结果
        animal.eat();

    }
}
```
13.思考为什么我们需要建立接口？了解依赖导致原则（Dependence Inversion Principle）的好处。[提交prac.md文件]

14.了解抽象类和接口的区别，请自己动手进行试验。[提交代码和prac.md文件]

### 数据库练习（使用Mysql数据库）
**自己创建MD文件，以下所有练习都需要把SQL记录到sql.md文件中**

0.创建名为practice的数据库
1.创建学生表，该表属性有ID（要求利用数据库自增长，主键）、学生ID、课程ID、分数
2.向表中插入一条学生ID为1、课程ID为1、分数为99的信息
3.更改数据中学生ID为1，课程ID为1的成绩，把分数从99改成100
4.删除学生ID为1，课程ID为1的成绩

#### 接下来操作需要导入我们提供的数据
##### 函数练习
* 使用名为practice的数据库
* 把我们提供的数据（prac.sql）导入到practice数据库中（具体语法请查mysql source语法）具体会有四张表，分别是score/student/orders/products[数据下载地址](http://example.com)

5.查找学生ID为1的学生最高成绩（使用max函数）
6.查找学生ID为1的学生最低成绩（使用min函数）
7.找出各门课程的最高成绩（使用max/groupBy函数）
8.找出各门课程的最高成绩,如果这门课程参与人数少于2人，则不参与统计（使用max/groupBy/having/count函数）
如有下列数据

| id      |    student_id | course_id  |score  |
| :---- | --------:| :--: |:--: |
| 1  | 1  |  1   | 90|
| 2  | 2  |  1   | 95|
| 3  | 3  |  1   | 100|
| 4  | 4  |  2   | 100|

则只应该被检索出来下面这条数据（课程2因为参与人数少于2人，因此不参与统计）
| course_id  |score  |
| :--: |:--: |
|  1   | 100|
9.找出各门课程的平均成绩（使用avg/groupBy函数）
10.查找学生ID为1学生的所有成绩，成绩按从高往低显示
11.查找学生ID为1并且课程ID为1的姓名和成绩（使用score和student两张表联合查询，观察两个表结构）

##### 索引练习
给出下面每个需求的SQL语句,然后思考能否使用索引进行查询优化,若能,则给出建立索引的方式和理由,并比较建立索引前后查询时间和查询计划(注意,这里是两方面!!)的变化;若不能,说明原因。提示:使用explain进行查询计划的查看,需给出截图展示,可酌情给出解释,但不要过多赘述。
1. 问题1:在 orders 表中找出购买人年龄小于20岁的order列表。
2. 问题2:在 orders 表中找出所有姓王的人的order列表。
3. 问题3:统计 orders 表中所有男性的人的数量。
4. 问题4:在 orders 表中计算女性,姓张,年龄大于50,且消费小于100的人数。 5. 问题5:统计 orders 表中姓名为三个字的人数。
6. 问题6:在 products 表中查找库存大于150的product列表。
