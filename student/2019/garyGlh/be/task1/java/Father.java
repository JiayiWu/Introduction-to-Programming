public class Father {
    String name;
    String id;
    public void run(){
        System.out.println("Father run.");
    }
    public Father(){
        System.out.println("father inits.");
    }
    public Father(String s){
        this.id=s;
        //System.out.println(name);
    }
}

class Son extends Father{
    public void run(){
        System.out.println("Son run.");
    }
    public Son(){
        System.out.println("Son inits.");
    }
    public Son(String s){
        this.name=s;
        System.out.println(name);
    }
}

class Grandson extends Son{
    public Grandson(){
        System.out.println("Grandson inits.");
    }
    public Grandson(String s){
        this.name=s;
        System.out.println(name);
    }
}
class Father_Son_Test{
    public static void main(String[] args){
        System.out.println("Now new a son:");
        Son son = new Son();
        //son.run();
        System.out.println("Now new a grandson:");
        Grandson grandson = new Grandson();

        System.out.println("现在用有参数的初始化");
        System.out.println("Now new a son:");
        Son son1 = new Son("guolihua");
        System.out.println("检查成员变量的初始化情况：");
        System.out.println("The name is:"+son1.name);
        System.out.println("The id is:"+son1.id);
        System.out.println("Now new a grandson:");
        Grandson grandson1 = new Grandson("guo");
    }
}
