class Solution2 {
    public int[] twoSum(int[] nums, int target){
        int[] return_arr = new int[2];
        for(int i = 0;i<nums.length;i++){
            for(int j = i;j<nums.length;j++){
                if(nums[j]+nums[i]==target){
                    return_arr[0] = i;
                    return_arr[1] = j;
                }
            }
        }
        return return_arr;
    }
}
