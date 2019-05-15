package Solution;
import java.util.*;
class Solution3 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> result = new HashMap<Integer,Integer>();
        int result1;
        int m;
        for (int i = 0;i<nums.length;i++) {
        	if(!result.containsKey(nums[i])) {
        		result.put(nums[i], 1);
        	}else {
        		result.put(nums[i],result.get(nums[i])+1);
        	}    
        }
        int max = 0;
        m = 0;
        for (int i = 0;i<nums.length;i++) {
        	if (result.get(nums[i])>max) {
        		max = result.get(nums[i]);
        		m = i;
        	}
        }
        return nums[m];
    }
    public static void main(String[] args) {
    	Solution3 s = new Solution3();
    	int[] nums = {1,2,3,3};
    	System.out.print(s.majorityElement(nums));
    }
}
