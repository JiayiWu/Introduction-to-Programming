package Solution;

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums.length==0||nums.length==1||nums==null) {
        	System.out.println("ERROR");
    		return result;
    	}
        int target1 = 0;
        for (int i = 0;i<nums.length-1;i++) {
        	for (int j = i+1;j<nums.length;j++) {
        		if(nums[i]+nums[j]==target) {
        			result[0] = i;
        			result[1] = j;
        			return result;
        		}
        	}
        }
        return null;
    }
    public static void main(String[] args) {
    	Solution2 s = new Solution2();
    	int [] nums = {};
    	int [] result = s.twoSum(nums, 9);
    	System.out.print(result[0]+" "+result[1]);
    }
}
