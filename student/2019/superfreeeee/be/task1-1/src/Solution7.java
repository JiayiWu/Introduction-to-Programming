import java.util.Scanner;

/**
 * Solution7
 */
public class Solution7 {
  public int fib(int N){
    if(N==1 || N==0){
      return N;
    }else{
      int front = 0;
      int rear = 1;
      int temp;
      while(N>1){
        temp = rear;
        rear = front+rear;
        front = temp;
        N--;
      }
      return rear;
    }
  }
  // 递归
  public int fib2(int N){
    if(N==1 || N==0)
      return N;
    else
      return fib2(N-2)+fib2(N-1);
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int target = in.nextInt();
    int result = new Solution7().fib(target);
    int result2 = new Solution7().fib2(target);
    System.out.println(result);
    System.out.println(result2);
  }
}