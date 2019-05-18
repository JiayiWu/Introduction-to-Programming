import java.util.ArrayList;
import java.util.List;

class solution3 {
    public int majorityElement(int[] nums) {
        List<Integer> new_nums = new ArrayList<Integer>();
        //去重
        for(int element0:nums){
           if (!new_nums.contains(element0)){
               new_nums.add(element0);
           }
        }
        int[] count = new int[new_nums.size()];
        for (int i = 0;i<new_nums.size();i++){
            for (int j = 0;j<nums.length;j++){
                if (new_nums.get(i)==nums[j]){
                    count[i]++;
                }
            }
        }
        int return_num = 0;
        int max = 0;
        for (int i = 0; i<count.length;i++){
            if (count[i]>max){
                max = count[i];
                return_num = new_nums.get(i);
            }
        }
        return return_num;
    }
}
