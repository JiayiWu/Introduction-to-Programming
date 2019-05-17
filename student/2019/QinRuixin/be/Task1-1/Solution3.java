package Task1_1;

import java.util.HashMap;

class Solution3 {
    public int majorityElement(int[] nums){
        HashMap<Integer,Integer> hs = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(hs.containsKey(nums[i])){
                hs.put(nums[i],hs.get(nums[i])+1) ;
            }else {
                hs.put(nums[i],1);
            }
        }
        int max = 0;
        int majority = 0;
        for(int i:hs.keySet()){
            if(hs.get(i)>max){
                max=hs.get(i);
                majority = i;
            }
        }

        return majority;
    }
}
