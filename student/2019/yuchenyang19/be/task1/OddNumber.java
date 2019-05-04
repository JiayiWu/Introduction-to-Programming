public class OddNumber {
	public static void main(String[] args) {
		//判断奇偶性
		int n = 7;
		if(n%2==0){
			System.out.println(n+"为偶数");
		}else{
			System.out.println(n+"为奇数");
		}
		
		//判断闰年
		int y = 2019;
		if (y%4==0 && y%100!=0){
            System.out.printf(y+"年是闰年");
        }
		else if(y%400==0){
            System.out.printf(y+"年是闰年");
        }
		else{
            System.out.printf(y+"年不是闰年");
        }
	}
}
