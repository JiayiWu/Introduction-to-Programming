class Father{
  {
    System.out.println("Father member build");
  }
  public Father(){
    System.out.println("Father constructor");
  }
  public void run(){
    System.out.println("Father run()");
  }
}
class Son extends Father{
  {
    System.out.println("Son member build");
  }
  public Son(){
    System.out.println("Son constructor");
  }
  public void run(){
    System.out.println("Son run()");
    super.run();
  }
}
public class Q10to11{
  public static void main(String[] args) {
    new Father().run();
    System.out.println("--------------");
    new Son().run();
  }
}