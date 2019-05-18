package Task1_1;

import java.util.*;

class Solution4 {
    public int romanToInt(String s) {
        char[] cArray = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        ArrayList<Character> al = new ArrayList<>();
        for (char c : cArray
        ) {
            al.add(c);
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put(cArray[0], 1);
        hm.put(cArray[1], 5);
        hm.put(cArray[2], 10);
        hm.put(cArray[3], 50);
        hm.put(cArray[4], 100);
        hm.put(cArray[5], 500);
        hm.put(cArray[6], 1000);

        char[] inputs = s.toCharArray();
        int ans = 0;
        int idx = 0;

        ans += hm.get(inputs[inputs.length-1]);

        for (int i = 1; i < inputs.length; i++) {
            idx = al.indexOf(inputs[i]);
            if (idx > al.indexOf(inputs[i - 1])) {
                ans -= hm.get(inputs[i-1]);
            } else {
                ans += hm.get(inputs[i-1]);
            }
        }
        return ans;
    }

}
