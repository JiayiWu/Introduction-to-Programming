package Task1_1;

class Solution6 {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            if(timeSeries.length==0){
                return 0;
            }
            int total = 0;
            int temp = timeSeries[0]+duration;
            for (int i = 1; i < timeSeries.length; i++) {
                if(temp>=timeSeries[i]){
                    total += timeSeries[i]-timeSeries[i-1];
                }else {
                    total +=duration;
                }
                temp = timeSeries[i]+duration;
            }
            total+=duration;
            return total;

        }

}
