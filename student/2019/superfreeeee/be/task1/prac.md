###Java
8.
FileInputStream, FileOutputStream基于InputStream, OutputStream为字节流，相对于Reader, Writer为字符流
new FileInputStream(new File(path))
new FileOutputStream(new File(path))
FileInputStream, FileOutputStream以File对象为参数，File对象以代表文件路径的字符串为参数

文件不存在则抛出运行时异常RuntimeError: FileNotFoundException（用try...catch捕获）
>>>java.io.FileNotFoundException: asset/test1.txt (No such file or directory)

10.
方法的定义依据是方法名+方法参数与顺序，与返回类型、参数名无关
因此：

int add(int a, int b)
String add(int c, int c)
将被视为同一个方法重复定义而报错

int add(int a, int b)
String add(String a, String b)
double add(double a, double b)
才是正确的重载方法

10-2.
参照Q10to11.java
new Father().run();
new Son().run();
son类覆盖了父类的方法所以.run()时调用的是Son对象的方法而不是Father对象的方法

11.
参照Q10to11.java
子类对象实例化过程：
父类成员变量实例化 -> 父类构造器调用 -> 子类成员变量实例化 -> 子类构造器调用 -> 子类对象创建完成（内部有一个隐藏的父类对象，用super调用）

12.
参照Q12.java
Animal dog = new Dog(), cat = new Cat();
dog, cat为Animal类型的引用变量，分别引用了Dog对象与Cat对象
dog, cat只能调用Animal里面有声明的方法，而实际调用的是Dog, Cat类中实现的方法

13.
在java一切皆为对象的世界观中，一个个类都必属于某个基类的派生类，形成一个个继承树，然而有些特征或方法集比抽象父类更为抽象，可以适用于不同的继承树，因此采用接口让类来继承。
当想使用接口的方法时，就可以接收所有实现接口的类作为参数，调用抽象接口声明的方法，而不在乎每个类具体的实现，降低客户端与具体实现的耦合。

14.
接口为完全抽象的方法集合，所有方法默认为抽象的
抽象类能够实现一些与子类无关的方法，或是为子类创建默认版本的方法实现，使子类不必覆写所有方法
