class solution7 {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return fib(N-1)+fib(N-2);
    }
}