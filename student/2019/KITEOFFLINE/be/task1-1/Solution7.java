public class Solution7 {
    public static int fib1(int N){
        if (N == 0){
            return 1;
        } else if (N == 1){
            return 1;
        } else if (N == 2){
            return 2;
        } else {
            int num1 = 1, num2 = 1, sum = 2;
            while (N - 2 > 0){
                num1 = num2;
                num2 = sum;
                sum = num1 + num2;
                N--;
            }
            return sum;
        }
    }
    public static int fib2(int N){
        if (N == 0 || N == 1){
            return 1;
        }
        return fib2(N-1) + fib2(N-2);
    }

    /*public static void main(String[] args) {
        System.out.println(fib1(7));
        System.out.println(fib2(7));
    }*/
}
