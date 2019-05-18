import java.util.Scanner;
/**
 * Solution6
 */
public class Solution6 {
  public int findPoisonedDuration(int[] timeSeries, int duration){
    if(timeSeries.length == 1){
      return duration;
    }
    int result = duration;
    for(int i=1 ; i<timeSeries.length ; i++)
      result += timeSeries[i-1] + duration - 1 < timeSeries[i] ? duration: timeSeries[i]-timeSeries[i-1];
    return result;
  }
  public static void main(String[] args) {
    int[] t = {1, 2, 5, 6, 8, 9, 13};
    int d = 3;
    int result = new Solution6().findPoisonedDuration(t, d);
    System.out.println(result);
  } 
}