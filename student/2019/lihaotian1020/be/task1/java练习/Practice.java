public class Practice {
    public static void main(String[] args){
        System.out.println(add(3,2));
        System.out.println(add(1,2,3));
        System.out.println(add(1,2,3,4));
    }
    public static int add(int a,int b){
             return a+b;
    }
    public static int add(int a,int b,int c){
        return a+b+c;
    }
    public static int add(int a,int b,int c,int d){
        return a+b+c+d;
    }
}

