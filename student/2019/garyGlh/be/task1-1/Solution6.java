public class Solution6 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res;
        res=duration*timeSeries.length;
        int delta;
        for(int i=1;i<timeSeries.length;i++){
            delta=timeSeries[i]-timeSeries[i-1];
            res=res-Math.max(0,duration-delta);
        }
        return res;
    }
    public static void main(String[] args){
        int[] timeSeries = {1,2};
        Solution6 test = new Solution6();
        System.out.println(test.findPoisonedDuration(timeSeries,2));
    }
}
