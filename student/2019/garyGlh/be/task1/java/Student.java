//该实验仿照菜鸟教程
public abstract class Student {
    private String name;
    private String id;
    private double gpa;
    public Student(String name,String id,double gpa){
        System.out.println("constructing a student:");
        this.name=name;
        this.id=id;
        this.gpa=gpa;
    }
    public String getName(){
        return this.name;
    }
    public String getId(){
        return this.id;
    }
    public double getGpa(){
        return this.gpa;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setGpa(double gpa){
        this.gpa=gpa;
    }
    public void print_info(){
        System.out.println(id+":"+name+" "+gpa);
    }
}
class UniversityStu extends Student{
    private int height;
    public UniversityStu(String name,String id,double gpa,int height){
        super(name,id,gpa);
        this.height=height;
    }
    public int getHeight(){
        return height;
    }
    public void setHeight(int height){
        this.height=height;
    }
    public void print_infos(){
        System.out.println(super.getId()+":"+
                super.getName()+" "+
                this.getHeight()+"cm"+" "+
                super.getGpa());
    }
}
class abstract_class_test{
    public static void main(String[] args){
        Student stu1 = new UniversityStu("guolihua","181250038",4.0,160);
        stu1.print_info();
        ((UniversityStu) stu1).print_infos();
    }
}