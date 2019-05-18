import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
/**
 * Solution2
 */
public class Solution2 {
  public int[] twoSum(int[] nums, int target){
    LinkedList<Integer> list = new LinkedList<Integer>();
    for(Integer i : nums)
      list.add(i);
    Collections.sort(list);
    for(int i : list)
      if(list.contains(target-i) && i!=target-i)
        return new int[]{list.indexOf(i), list.indexOf(target-i)};
    System.out.println("not found");
    return new int[]{};
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int target = in.nextInt();
    System.out.println(Arrays.toString(new Solution2().twoSum(new int[]{11, 55, 22, 88, 99}, target)));
  }
}