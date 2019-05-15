interface Animal{
  public void eat();
}
class Dog implements Animal{
  public void eat(){
    System.out.println("Dog eat()");
  }
}
class Cat implements Animal{
  public void eat(){
    System.out.println("Cat eat()");
  }
}
public class Q12{
  public static void main(String[] args) {
    Animal dog = new Dog(), cat = new Cat();
    dog.eat();
    cat.eat();
  }
}