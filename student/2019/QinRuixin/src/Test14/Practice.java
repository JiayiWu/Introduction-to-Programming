package Test14;

public class Practice {
    public static void main(String[] args) {
        Person person = new Student();
        person.eat();
        person = new Teacher();
        person.eat();

        Teacher teacher = (Teacher)person;
        teacher.sleep();
        teacher.work();
        teacher.study();
        person.study();

        //java8后接口可以有默认方法与静态方法
        teacher.attendMeeting();
        Employee.printOrg();

    }
}
