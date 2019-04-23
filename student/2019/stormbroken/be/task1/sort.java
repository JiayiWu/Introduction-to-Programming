package 党员系统;
import java.util.*;
public class sort {
		public static void main (String[] args) {
			int middle;
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入一行数字:");
			String [] number = scan.nextLine().split(" ");
			int [] number1 =new int[number.length];
			for (int i = 0;i<number.length;i++) {
				number1[i]=Integer.parseInt(number[i]);
			}
			//冒泡排序
			for (int i = 0;i<number1.length;i++) {
				for (int j = 0;j<number1.length-i-1;j++) {
					if (number1[j]>number1[j+1]) {
						middle = number1[j];
						number1[j]=number1[j+1];
						number1[j+1]=middle;
					}
				}
			}
			for(int m:number1) {
				System.out.print(m+" ");
			}
			
			
			for (int i = 0;i<number.length;i++) {
				number1[i]=Integer.parseInt(number[i]);
			}
			//选择排序
			int situation =0 ;
			for(int i = 0;i<number1.length-1;i++) {
				for(int j = i;j<number1.length;j++) {
					if (number1[j]<number1[situation]) {
						situation = j;
					}
				}
				middle = number1[situation];
				number1[situation] = number1[i];
				number1[i]=middle;
				
			}
			for(int m:number1) {
					System.out.print(m+" ");
			}
			
		}
}
