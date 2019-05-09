class Solution9 {
    public int climbStairs(int n) {
        int a = 1, b = 1, c = 2;
        if(n == 0) return a;
        if(n == 1) return b;
        for(int i=2; i<=n; ++i) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.climbStairs(3));
    }
}