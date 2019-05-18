import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution4 {
  public int romanToInt(String s) {
    int[] temp = new int[s.length()];
    int i = 0;
    for(char c : s.toCharArray()){
      switch(c){
        case 'I': temp[i++]=1; break;
        case 'V': temp[i++]=5; break;
        case 'X': temp[i++]=10; break;
        case 'L': temp[i++]=50; break;
        case 'C': temp[i++]=100; break;
        case 'D': temp[i++]=500; break;
        case 'M': temp[i++]=1000; break;
      }
    }
    // System.out.println(Arrays.toString(temp));
    int result = temp[0];
    for(i=1 ; i<temp.length ; i++){
      result += temp[i];
      if(temp[i-1] < temp[i])
        result -= temp[i-1]*2;
    }
    return result;
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();

    int result = new Solution4().romanToInt(s);
    System.out.println(result);
  }
}