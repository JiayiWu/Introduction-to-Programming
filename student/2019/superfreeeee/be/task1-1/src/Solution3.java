import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution3 {
  public int majorityElement(int[] nums) {
    int times = 0;
    int result = 0;
    int temp;
    for(int i : nums){
      temp = 0;
      for(int j : nums)
        if(i == j)
          temp++;
      if(temp > times){
        result = i;
        times = temp;
      }
    }
    return result;
  }
  public static void main(String[] args) {
    int[] sample = {1,2,3,4,5,6,7,8,4,2,4,2,3,2};
    System.out.println(new Solution3().majorityElement(sample));
  }
}