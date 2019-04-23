package 党员系统;

public class Caculator {
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			int a = 12 ;
			int b = 5;
			System.out.println("a+b = "+(a+b));
			System.out.println("a-b = "+(a-b));
			System.out.println("a*b = "+a*b);
			System.out.println("a/b = "+a/b);
			System.out.println("a%b = "+a%b);
			int c ;
			c = a++;
			System.out.println("c = a++ = "+c);
			a = 12;
			c = ++a;
			System.out.println("c = ++a = "+c);
			System.out.println("12 == 5 = "+(12 == 5));
			System.out.println("12 !=5 = "+(12 != 5));
			System.out.println("12>5 = "+(12>5));
			System.out.println("12<5 = "+(12<5));
			System.out.println("12>=5 = "+(12>=5));
			System.out.println("12<=5 = "+(12<=5));
			a = 12;
			System.out.println("a*4 = "+(a*4));
			System.out.println("a*4 = a<<2 ="+(a<<2));
		}
}
