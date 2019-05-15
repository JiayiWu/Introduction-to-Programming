class Solution7 {
    public int fib(int N) {
        int a = 0, b = 1, c = 1;
        if(N == 0) return a;
        if(N == 1) return b;
        for(int i=2; i<=N; ++i) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        System.out.println(solution7.fib(2));
    }
}