public class Son extends Father{
    public Son(){
        System.out.println("Son is constructed");
    }
    public void run(){
        System.out.println("Son");
    }
    public static void main(String[] args){
        Son son = new Son();
        son.run();
    }
}