package ��Աϵͳ;
import java.util.*;
import java.math.*;
public class PrimeNumber {
		public static void main (String[] args) {
			Scanner scan = new Scanner(System.in);
			System.out.println("������һ�����֣�");
			int number = scan.nextInt();
			boolean result = true;
			for (int i = 2;i<Math.sqrt(number);i++) {
				if (number%i==0) {
					result = false;
				}
			}
			if (result) {
				System.out.println(number+"��һ������");
			}else {
				System.out.println(number+"����һ������");
			}
		}
}
