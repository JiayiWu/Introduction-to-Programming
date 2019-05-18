import java.util.Arrays;
import java.util.Scanner;

public class Solution5{
  public int numDecodings(String s){
    if(s.length() == 0 || s.charAt(0) == '0')
      return 0;
    int[] result = new int[s.length()+1];
    result[0] = result[1] = 1;
    // System.out.println(Arrays.toString(result));
    for(int i=1 ; i<s.length() ; i++){
      // System.out.println("i = "+i);
      result[i+1] = s.charAt(i)=='0'? 0: result[i];
      if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'&&s.charAt(i)<='6'){
        result[i+1] += result[i-1];
      }
      // System.out.println(Arrays.toString(result));
    }
    return result[s.length()];
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();

    int result = new Solution5().numDecodings(s);
    System.out.println(result);
  }
}