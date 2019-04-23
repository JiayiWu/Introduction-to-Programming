package 党员系统;
import java.util.*;
public class Odd {
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入一个整数：");
			int number = scan.nextInt();
			if(number % 2 == 0) {
				System.out.println(number+"是个偶数。");
			}else {
				System.out.println(number+"是个奇数。");
			}
		}
}
