import java.util.*;

public class Sorting{
	public static void main (String[] args) {
		Scanner reader = new Scanner(System.in);
		String[] a = reader.nextLine().split(" ");
		int[] b = new int[a.length];
		int temp;
		for (int i = 0;i<a.length;i++) {
			b[i]=Integer.parseInt(a[i]);
		}
		
		//冒泡
		for (int i=0;i<b.length;i++){
			for (int j = 0;j<b.length-i-1;j++){
				if (b[j]<b[j+1]){
					temp = b[j];
					b[j]=b[j+1];
					b[j+1]=temp;
				}
			}
		}
		for(int k:b) {
			System.out.print(k+" ");
		}
		
		//选择
		for(int i = 0;i<b.length-1;i++) {
			int situation = i;
			for(int j = i;j<b.length;j++) {
				if (b[j]>b[situation]) {
					situation = j;
				}
			}
			temp = b[situation];
			b[situation] = b[i];
			b[i]=temp;
		}
		for(int k:b) {
				System.out.print(k+" ");
		}
	}
}
