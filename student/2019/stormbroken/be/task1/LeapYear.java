package ��Աϵͳ;
import java.util.*;
public class LeapYear {
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			System.out.println("������һ����ݣ�");
			int year = scan.nextInt();
			boolean result = false;
			if (year % 4 == 0){
				result = true;
				if (year%100 == 0) {
					result = false;
					if(year % 400 == 0) {
						result = true;
					}
				}
			}
			if (result) {
				System.out.println(year+ " �����ꡣ");
			}else {
				System.out.println(year+ " �������ꡣ");
			}
		}
}
