public class Test6 {
    //判断素数
    public static void main(String[] args) {
        int a = 19;
        int sqrt = (int)Math.sqrt(a);
        boolean isPrime = true;
        for (int i = 2; i <= sqrt; i++) {
            if(a%i==0){
                isPrime=false;
                break;
            }
        }
        if(isPrime){
            System.out.println("是素数");
        }else {
            System.out.println("不是素数");
        }

    }

}
