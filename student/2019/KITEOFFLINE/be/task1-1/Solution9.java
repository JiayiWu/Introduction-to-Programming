public class Solution9 {
    public int climbStairs(int n){
        if (n == 1){
            return 1;
        } else if (n == 2){
            return 2;
        } else {
            return climbStairs(n-1)+climbStairs(n-2);
        }
    }

    /*public static void main(String[] args) {
        System.out.println(new Solution9().climbStairs(5));
    }*/
}
