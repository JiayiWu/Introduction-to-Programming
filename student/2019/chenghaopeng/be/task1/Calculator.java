public class Calculator{
    public static void main(String[] args){
        int a = 12, b = 5;
        System.out.printf("a+b=%d, a-b=%d, a*b=%d, a/b=%d, a%%b=%d\n", a+b, a-b, a*b, a/b, a%b);
        int c = a++;
        System.out.printf("c=%d\n", c);
        c = ++a;
        System.out.printf("c=%d\n", c);
        System.out.printf("a=%d\n", a);
        int d = a << 2;
        System.out.printf("d=%d\n", d);
    }
}