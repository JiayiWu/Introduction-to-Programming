import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int majorityElement(int[] nums) {
        int anscnt = 0, ans = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int num : nums) {
            Integer cnt = hashMap.get(num);
            if(cnt == null) cnt = 1;
            else cnt++;
            hashMap.put(num, cnt);
            if(cnt > anscnt) {
                anscnt = cnt;
                ans = num;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}