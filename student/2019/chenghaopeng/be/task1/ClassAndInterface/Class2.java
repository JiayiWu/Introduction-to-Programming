public class Class2 extends Class1 implements Interface1, Interface2{
    public static void fun(){
        System.out.println(fun1().toString() + " " + fun2().toString());
    }
    public void f1(){
        System.out.println("f1");
    }
    public void f2(){
        System.out.println("f2");
    }
    public static void main(String[] args){
        fun();
    }
}