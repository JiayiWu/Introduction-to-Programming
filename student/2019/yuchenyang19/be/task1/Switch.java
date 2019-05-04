public class Switch {
	public static void main(String[] args) {
		int number = 10;
		
		if(number == 10){
			System.out.println("10");
		}
		else if(number == 20) {
			System.out.println("20");
		}
		else if(number ==30) {
			System.out.println("30");
		}
		else if(number == 40) {
			System.out.println("40");
		}
		else if(number == 50) {
			System.out.println("50");
		}
		else{
			System.out.println("错误");
		}

		//switch优化
		switch(number) {
		case 10:
			System.out.println("10");
		case 20:
			System.out.println("20");
		case 30:
			System.out.println("30");
		case 40:
			System.out.println("40");
		case 50:
			System.out.println("50");
		default:
			System.out.println("错误");
		}
	}
}
