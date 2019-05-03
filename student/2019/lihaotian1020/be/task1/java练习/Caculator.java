public class Caculator {
    public static void main(String[] args){
        int a = 12;
        int b = 5;
        System.out.println("a + b = " + (a + b) );
        System.out.println("a - b = " + (a - b) );
        System.out.println("a * b = " + (a * b) );
        System.out.println("a / b = " + (a / b) );
        System.out.println("a % b = " + (a % b) );
        int c;
        c = a++; //先将a赋值给c 然后做a++的操作，此时c=12 a = 13；
        System.out.println(c);
        c = ++a; //先做a=a+1；此时a = 14 c = 14；
        System.out.println(c);
        a = 1;
        b = 1;
        if(a==b){
            System.out.println("a equal to b");
        }
        a = 12;
        b = 5;
        if (a!=b) {
            System.out.println("a not equal to b");
        }
        if (a>b){
            System.out.println("a is bigger than b");
        }
        a = 5;b = 12;
        if (a<b){
            System.out.println("a is smaller than b");
        }
        a = 5;b = 5;
        if (a<=b){
            System.out.println("a is smaller or equal to b");
        }
        if (a>=b){
            System.out.println("a is bigger or equal to b");
        }
        a = 12;
        int multy = 0;
        for(int i =0;i<4;i++){
            multy = multy + a;
        }
        System.out.println(multy);
    }
}
