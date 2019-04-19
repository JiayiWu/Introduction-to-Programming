public class Parity{
    public static void main(String[] args){
        judgeOdd(2);
        judgeOdd(3);
        judgeLeap(2000);
        judgeLeap(2020);
        judgeLeap(3000);
    }
    private static void judgeOdd(int n){
        System.out.printf("%d is ", n);
        if(!isOdd(n)){
            System.out.printf("not ");
        }
        System.out.printf("odd.\n");
    }
    private static boolean isOdd(int n){
        return (n & 1) == 1;
    }
    private static void judgeLeap(int n){
        System.out.printf("%d is ", n);
        if(!isLeap(n)){
            System.out.printf("not ");
        }
        System.out.printf("leap year.\n");
    }
    private static boolean isLeap(int n){
        return (n % 400 == 0) || (n % 4 == 0 && n % 100 != 0);
    }
}