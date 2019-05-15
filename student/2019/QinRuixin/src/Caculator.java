public class Caculator {
    public static void main(String[] args) {
        int a = 12;
        int b = 5;

        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);//整型除法，得到整型2
        System.out.println(a%b);

        int c = a;
        System.out.println(c==a++);//先做操作后自增
        System.out.println(String.format("c: %d\na: %d",c,a));
        c=a;
        System.out.println(c!=++a);//先自增后做操作
        System.out.println(String.format("c: %d\na: %d",c,a));

        //Caculator扩展
        //方法一
        int d = 4*a;

        //方法二，位运算，高效
        d = a<<2;
        System.out.println("a * 4 = "+d);
    }
}
