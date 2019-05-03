package 党员系统;
import java.util.*;
public class Switch {
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入一个整数：");
			int number = scan.nextInt();
			if (number == 10){
				System.out.println("你输入了10");
			}else if (number == 20) {
				System.out.println("你输入了20");
			}else if (number ==30) {
				System.out.println("你输入了30");
			}else if (number == 40) {
				System.out.println("你输入了40");
			}else if (number == 50) {
				System.out.println("你输入了50");
			}else {
				System.out.println("错误的输入");
			}
			System.out.println("接下来是优化的代码");
			switch(number) {
			case 10:
				System.out.println("你输入了10");
			case 20:
				System.out.println("你输入了20");
			case 30:
				System.out.println("你输入了30");
			case 40:
				System.out.println("你输入了40");
			case 50:
				System.out.println("你输入了50");
			default:
				System.out.println("错误的输入");
			}
			
		}
}
