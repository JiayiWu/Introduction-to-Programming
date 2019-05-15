import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int index_1=0;
        int index_2=0;
        for(;index_1<nums.length;index_1++)
        {
            for(index_2=index_1+1;index_2<nums.length;index_2++)
            {
                if(nums[index_1]+nums[index_2]==target)
                {
                    res[0]=index_1;
                    res[1]=index_2;
                    return res;
                }
            }
        }
        return res;
    }
}
