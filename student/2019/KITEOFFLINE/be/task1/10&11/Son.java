public class Son extends Father {
//    10.新建一个Father类，同时自定义一个run方法。
//    再新建一个Son类，继承Father类（使用extends字段），
//    同时在该类中定义一个run方法。然后建立Main方法，
//    并new Son类执行run方法，观察具体调用的是哪个run方法。
//    11.新建Father类和Son类，并且Son类继承Father类，
//    思考在new Son对象的时候对象初始化顺序，
//    即只调用子类构造器还是先调用子类构造器再调用父类构造器亦或是顺序相反。
//    建议自己想一个方法进行验证。[提交代码和prac.md文件]
    Son(){
        System.out.println("Son's constructor is running.");
    }
    public void run(){
        System.out.println("Son is running.");
    }

    public static void main(String[] args) {
        new Son().run();
    }
}
// overrides 调用子类方法。
//先父类构造器运行再子类构造器运行（由运行结果知）
