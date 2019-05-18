import java.util.Arrays;
public class Solution3 {
    public int majorityElement(int[] nums) {
        if(nums.length==1)
            return nums[0];
        Arrays.sort(nums);
        int max_count=1;
        int max_num=nums[0];
        int current_count=1;
        int index=0;
        for(int i=1;i<nums.length;i++)
        {

            if(nums[i]!=nums[i-1])
            {

                if(i-index>max_count)
                {
                    max_num=nums[i-1];
                }
                index=i;
            }
        }
        if(nums.length-index>max_count)
        {
            max_count=current_count;
            max_num=nums[nums.length-1];
        }
        return max_num;
    }
}
