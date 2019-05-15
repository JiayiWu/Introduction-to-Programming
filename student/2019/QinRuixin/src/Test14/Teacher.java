package Test14;

public class Teacher extends Person implements Employee,Parent {
    @Override
    public void eat() {
        System.out.println("老师在吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("老师在睡觉");
    }

    @Override
    public void study() {
        System.out.println("老师在学习");
    }

    @Override
    public void work() {
        System.out.println("老师在工作");
    }


    @Override
    public void adoptKids() {
        System.out.println("养育孩子");
    }
}
