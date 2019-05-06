经历了打错、少打等挫折，总算是搞定了。

1、中间出了点小问题，把student_id的属性设置错了给改了一下![https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20190503205752.png](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/微信截图_20190503205752.png)

2、![https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20190503210114.png](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/微信截图_20190503210114.png)

3、![3](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/3.png)

4、![4](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/4.png)

5、![5](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/5.png)

6、![6](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/6.png)

7、![7](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/7.png)

8、![8](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/8.png)

9、![9](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/9.png)

10、![10](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/10.png)

11、![11](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/11.png)

# 索引练习

1、	个人感觉可以优化，建立索引之后只需要对少量的数据进行操作，工作量减少。但是结果却和猜想不一样。。

使用前：![索引一前](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/索引一前.png)

使用后：![索引一后](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/索引一后.png)

![索引1](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/索引1.png)

2、个人直接使用的like 可以使用索引优化

使用前：![索引二前](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/索引二前.png)

使用后：![索引二后](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/索引二后.png)

![索引2](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/索引2.png)

3、不能优化，性别只有男女之分，数值集合只有两个元素。

![索引3](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/索引3.png)

4、在将name、age、sex都加入索引之后，会发现很快。而去除索引之后会慢很多。

使用前：![索引四前](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/索引四前.png)

使用后：![索引四后](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/索引四后.png)

![索引四](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/索引四.png)

![索引四而](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/索引四而.png)5、使用索引更好

![索引五时间](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/索引五时间.png)

![索引五](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/索引五.png)

6、事实证明使用了索引会加快速度

使用前：![6前](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/6前.png)

使用后：![6后](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/6后.png)

![六](https://github.com/JiayiWu/Introduction-to-Programming/blob/master/student/2019/lihaotian1020/be/task1/sql/六.png)