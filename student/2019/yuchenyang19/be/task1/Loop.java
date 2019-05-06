public class Loop {
	public static void main (String[] args) {
		//计算1+2+3+...+100
		//while
		int sum = 0;
		int i = 1;		
		while(i<=100) {
			sum = sum + i;
			i++;
		}
		System.out.println(sum);
		//do-while		
		sum = 0;
		i = 1 ;
		do {
			sum = sum +i;
			i++;
		}while(i<=100);
		System.out.println(sum);
		//for
		sum = 0;
		for (i=1;i<=100;i++) {
			sum = sum + i;
		}
		System.out.println(sum);
		//计算1+3+5+...+101
		//while
		sum = 0;
		i = 1;
		while(i<=101) {
			sum = sum + i ;
			i = i + 2;
		}
		System.out.println(sum);
		//do-while
		sum = 0;
		i = 1;
		do {
			sum = sum + i ;
			i = i + 2;
		}while(i<=101);
		System.out.println(sum);
		//for
		sum = 0;
		i = 1;
		for (i=1;i<=101;i = i + 2) {
			sum = sum + i;
		}
		System.out.println(sum);
		
		
		//遍历数组
		int[] num = {1,2,3,4,5};
		for (int i=0;i<num.length;i++){
			System.out.println(num[i]);
		}
	}
}
