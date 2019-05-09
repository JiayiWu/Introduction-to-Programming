class Solution5 {
    private static Boolean isAscCode(String s) {
        if(s.length() > 2) return false;
        if((s.charAt(0) > '2' || s.charAt(0) == '0') && s.length() == 2) return false;
        if(s.length() == 2 && s.charAt(0) == '2' && s.charAt(1) > '6') return false;
        return true;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n];
        f[0] = f[1] = 1;
        if(isAscCode(s.substring(0, 2)) == true) f[1]++;
        for(int i=2; i<n; ++i) {
            f[i] = f[i - 1];
            if(isAscCode(s.substring(i - 1, i + 1)) == true) f[i] += f[i - 2];
        }
        return f[n - 1];
    }
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.numDecodings("29"));
    }
}