public class Caculator {
    public static void main(String[] args) {
        int a = 12;
        int b = 5;
        System.out.printf("a + b = %d\na - b = %d\na * b = %d\na / b = %d\na %% b = %d\n", a+b, a-b, a*b, a/b, a%b);
        int c;
        c = a++;
        System.out.printf("c = %d\n", c);
        System.out.printf("a = %d\n", a);
        c = ++a;
        System.out.printf("c = %d\n", c);
        System.out.printf("a = %d\n", a);

//        下面是对a*4的扩展
        a = 12;
        a = a << 2;
        System.out.println(a);

    }
}
