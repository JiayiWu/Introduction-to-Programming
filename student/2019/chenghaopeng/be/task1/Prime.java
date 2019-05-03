public class Prime{
    public static void main(String[] args){
        judgePrime(2);
        judgePrime(3);
        judgePrime(20);
        judgePrime(1000000007);
    }
    private static void judgePrime(int n){
        System.out.printf("%d is ", n);
        if(!isPrime(n)){
            System.out.printf("not ");
        }
        System.out.printf("prime number.\n");
    }
    private static boolean isPrime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}