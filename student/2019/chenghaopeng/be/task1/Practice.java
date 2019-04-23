public class Practice {
    public static void main(String[] args){
        Animal animal = new Cat();
        //观察输出结果
        animal.eat();
        animal = new Dog();
        //观察输出结果
        animal.eat();

    }
}
/*public class Practice{
    int add (int a,int b){
        return a+b;
    }
        
    int add (int a,int b,int c){
        return a+b+c;
    }
        
    int add (int a,int b,int c,int d){
        return a+b+c+d;
    }

    int add (int a,int b){
        return a+b;
    }
        
    double add (int a,int b){
        return a+b+1.0;
    }
}*/