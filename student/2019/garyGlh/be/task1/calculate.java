
public class calculate {
    public static void main(String[] args)
    {
        int a=12;
        int b=5;
        System.out.println("a="+a+" b="+b);
        System.out.println("a+b="+(a+b));
        System.out.println("a-b="+(a-b));
        System.out.println("a*b="+a*b);
        System.out.println("a/b="+a/b);
        System.out.println("a%b="+a%b);
        System.out.println();

        int c=a++;
        System.out.println("after c=a++ :\n"+"c="+c+" a="+a);
        System.out.println("c==a?:"+(c==a));
        System.out.println("c!=a?:"+(c!=a));
        System.out.println("c>a?:"+(c>a));
        System.out.println("c<a?:"+(c<a));
        System.out.println("c>=a?"+(c>=a));
        System.out.println("c<=a?:"+(c<=a));
        System.out.println();

        a=12;
        c=++a;
        System.out.println("after c=++a :\n"+"c="+c+" a="+a);
        System.out.println("c==a?:"+(c==a));
        System.out.println("c!=a?:"+(c!=a));
        System.out.println("c>a?:"+(c>a));
        System.out.println("c<a?:"+(c<a));
        System.out.println("c>=a?"+(c>=a));
        System.out.println("c<=a?:"+(c<=a));

        System.out.println(multiply(a,4));
        System.out.println(multiply_2(a,4));
    }

    public static int multiply(int a, int b)
    {
        int res=0;
        for(int i=0;i<a;i++)
            res=res+b;
        return res;
    }

    public static int multiply_2(int a,int b)
    {
        if(a==0)
            return b;
        else
            return multiply(a,b);
    }


}
