package Test14;

public abstract class Person {
    public String name;

    public Person(){
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public abstract void eat();
    public abstract void sleep();
    public void study(){
        System.out.println("人在学习");
    }
}
