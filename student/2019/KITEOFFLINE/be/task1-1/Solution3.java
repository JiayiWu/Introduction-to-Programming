import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution3 {
    public static int majorityElement(int[] nums){
        Arrays.sort(nums);
        ArrayList<Integer> listCount = new ArrayList<>();
        ArrayList<Integer> listIndex = new ArrayList<>();
        int i = 0;
        while (i < nums.length){
            int count = 1;
            int index = i;
            int j;
            for (j = i + 1; j < nums.length; j++){
                if (nums[i] == nums[j]){
                    count++;
                } else {
                    break;
                }
            }
            i = j;
            listCount.add(count);
            listIndex.add(index);
        }
        int countMax = listCount.get(0);
        for (int k = 0; k <listCount.size(); k++){
            if (countMax < listCount.get(k)){
                countMax = listCount.get(k);
            }
        }
        return nums[listIndex.get(listCount.indexOf(countMax))];
    }

    /*public static void main(String[] args) {
        int[] nums = {2,2,1,1,6,6,6,7,7,7,7,7,7,7,7,7,7,1,2,2,3,6,6,6,6,2,3};
        System.out.println(majorityElement(nums));
    }*/
}
