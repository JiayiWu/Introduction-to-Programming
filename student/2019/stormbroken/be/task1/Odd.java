package ��Աϵͳ;
import java.util.*;
public class Odd {
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			System.out.println("������һ��������");
			int number = scan.nextInt();
			if(number % 2 == 0) {
				System.out.println(number+"�Ǹ�ż����");
			}else {
				System.out.println(number+"�Ǹ�������");
			}
		}
}
