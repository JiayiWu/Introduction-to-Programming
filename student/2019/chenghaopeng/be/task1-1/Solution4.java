class Solution4 {
    private static int charToInt(char a) {
        if(a == 'I') return 1;
        if(a == 'V') return 5;
        if(a == 'X') return 10;
        if(a == 'L') return 50;
        if(a == 'C') return 100;
        if(a == 'D') return 500;
        if(a == 'M') return 1000;
        return 0;
    }
    public int romanToInt(String s) {
        int ans = 0;
        for(int i=0; i<s.length(); ++i) {
            char a = s.charAt(i);
            int aa = charToInt(a);
            if(i != s.length() - 1) {
                char b = s.charAt(i + 1);
                int bb = charToInt(b);
                if(aa < bb) {
                    aa = -aa;
                }
            }
            ans += aa;
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.romanToInt("MCMXCIV"));
    }
}