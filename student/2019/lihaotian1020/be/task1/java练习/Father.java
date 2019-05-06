public class Father {
    public void run() {
        System.out.println("调用了父类");
    }
    static
    { System.out.println("父类静态初始化块");}
    { System.out.println("父类初始化块");      }
    private static int b = 1;
    public Father() {
        System.out.println("调用了父类无参构造器");
    }
    public Father(int b) {
        this.b = b;
        System.out.println("调用父类的有参构造器");
    }
}