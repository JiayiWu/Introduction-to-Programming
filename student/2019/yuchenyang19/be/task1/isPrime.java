public class isPrime{
    public static void main(String[] args) {
        int num = 256;
        boolean result = true;
        for(int i=2;i<num;i++){
            if(num%i==0){
                result = false;
                break;
            }
        }
        if(result){
            System.out.printf(num+"是素数");
        }
		else{
			System.out.printf(num+"不是素数");
		}
    }
}
