/**
 * Solution9
 */
public class Solution9 {
  public int climbStairs(int n){
    if(n==1 || n==2)
      return n;
    else
      return climbStairs(n-1)+climbStairs(n-2);
  }
  public static void main(String[] args) {
    int n = 3;
    int result = new Solution9().climbStairs(n);
    System.out.println(result);
  }
}