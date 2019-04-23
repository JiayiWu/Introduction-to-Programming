package 党员系统;
import java.util.*;
import java.math.*;
public class PrimeNumber {
		public static void main (String[] args) {
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入一个数字：");
			int number = scan.nextInt();
			boolean result = true;
			for (int i = 2;i<Math.sqrt(number);i++) {
				if (number%i==0) {
					result = false;
				}
			}
			if (result) {
				System.out.println(number+"是一个素数");
			}else {
				System.out.println(number+"不是一个素数");
			}
		}
}
