public class Caculator {
	public static void main(String[] args) {
		int a = 12;
		int b = 5;
		
		System.out.printf("a+b = %d\n",a+b);
		System.out.printf("a-b = %d\n",a-b);
		System.out.printf("a*b = %d\n",a*b);
		System.out.printf("a/b = %d\n",a/b);
		System.out.printf("a%%b = %d\n",a%b);
		
		int c;
		c = a++;
        System.out.printf("c = %d\n", c);
        System.out.printf("a = %d\n", a);
        c = ++a;
        System.out.printf("c = %d\n", c);
        System.out.printf("a = %d\n", a);
		
		//扩展
		a = 12;
		System.out.printf("a*4 = %d\n",a*4);
		System.out.printf("a*4 = %d\n",a<<2);
	}
}
