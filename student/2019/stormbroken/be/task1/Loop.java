package 党员系统;

public class Loop {
		public static void main (String[] args) {
			System.out.println("计算1+2+3+...+100 = ");
			int sum = 0;
			int count = 1;
			while (count <=100) {
				sum = sum + count;
				count = count + 1;
			}
			System.out.println(sum);
			sum = 0;
			count = 1 ;
			do {
				sum = sum +count;
				count = count + 1 ;
			}while (count <=100);
			System.out.println(sum);
			sum = 0;
			for (int i = 1;i<=100;i++) {
				sum = sum + i;
			}
			System.out.println(sum);
			System.out.println("计算1+3+5+...+101 = ");
			sum = 0;
			count = 1;
			while(count <=101) {
				sum = sum + count ;
				count = count + 2;
			}
			System.out.println(sum);
			sum = 0;
			count = 1;
			do {
				sum = sum + count ;
				count =count + 2;
			}while(count<=101);
			System.out.println(sum);
			sum = 0;
			count = 1;
			for (int i = 1;i<=101;i = i + 2) {
				sum = sum +i;
			}
			System.out.println(sum);
			
		}
}
