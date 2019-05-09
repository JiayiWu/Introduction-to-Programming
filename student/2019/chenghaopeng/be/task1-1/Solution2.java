import java.util.*;

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for(int i=0; i<nums.length; ++i) {
            for(int j=i+1; j<nums.length; ++j) {
                if(nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] ans = solution2.twoSum(new int[]{2, 7, 11, 15}, 9);
        if(ans != null) {
            System.out.println(Arrays.toString(ans));
        }
    }
}