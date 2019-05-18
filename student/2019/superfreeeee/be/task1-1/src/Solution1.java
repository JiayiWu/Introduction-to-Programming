import java.util.Scanner;

/**
 * Solution1
 */
public class Solution1{

  public String addBinary(String a, String b){
    return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String[] nums = input.nextLine().split(" ");
    System.out.println(new Solution1().addBinary(nums[0], nums[1]));
  }
}