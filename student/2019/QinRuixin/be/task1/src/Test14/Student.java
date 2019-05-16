package Test14;

public class Student extends Person {
    @Override
    public void eat() {
        System.out.println("学生在吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("学生在睡觉");
    }

}
