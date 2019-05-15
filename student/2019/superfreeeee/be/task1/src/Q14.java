interface Life{
  public void eat();
  public void walk();
}
abstract class Human implements Life{
  public abstract void eat();
  public void walk(){
    System.out.println("someone can walk");
  }
}
class Tom extends Human{
  public void eat(){
    System.out.println("Tom eat a lot");
  }
}
class Jack extends Human{
  public void eat(){
    System.out.println("Jack eat little");
  }
  public void walk(){
    System.out.println("Jack boke his leg so he can't walk");
  }
}
abstract class Pet implements Life{
  public void eat(){
    System.out.println("Animal can eat");
  }
  public abstract void walk();
}
class Lion extends Pet{
  public void walk(){
    System.out.println("Dog walks with four leg");
  }
  public void eat(){
    System.out.println("Dog only eat meat");
  }
}
class Duck extends Pet{
  public void walk(){
    System.out.println("Duck walks with two leg");
  }
}

public class Q14{
  public static void main(String[] args) {
    Human tom = new Tom();
    Human jack = new Jack();
    Pet lion = new Lion();
    Pet duck = new Duck();
    action(tom);
    action(jack);
    action(lion);
    action(duck);
  }
  public static void action(Life life){
    life.eat();
    life.walk();
  }
}