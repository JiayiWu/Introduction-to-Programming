class Solution6 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        for(int i=1; i<timeSeries.length; ++i) {
            if(timeSeries[i] - timeSeries[i - 1] < duration) {
                ans += timeSeries[i] - timeSeries[i - 1];
            }
            else {
                ans += duration;
            }
        }
        return ans + duration;
    }
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.findPoisonedDuration(new int[]{1, 3, 9, 10}, 3));
    }
}