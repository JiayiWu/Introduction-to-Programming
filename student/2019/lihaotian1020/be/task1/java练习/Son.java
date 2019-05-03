public class Son extends Father {
    public void run(){
        System.out.println("调用了子类");
    }
    static
    { System.out.println("子类静态初始化块"); }
    { System.out.println("子类初始化块");       }
    private static int a =1;
    public Son() {
        System.out.println("调用子类的构造器");
    }
    public Son(int a){
        this.a=a;
        System.out.println("调用子类的有参构造器");
    }
}
