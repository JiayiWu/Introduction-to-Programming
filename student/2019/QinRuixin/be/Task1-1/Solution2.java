package Task1_1;

import java.util.HashMap;

class Solution2 {
    public int[] twoSum(int[] nums,int target){
        HashMap<Integer,Integer> hs = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(!hs.containsKey(nums[i])){
                hs.put(nums[i],i) ;
            }
            if(hs.containsKey(target-nums[i])&&(target-nums[i]!=nums[i])){
                return new int[]{hs.get(target-nums[i]),i};
            }
        }
        return null;
    }
}
