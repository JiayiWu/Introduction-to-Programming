class solution6 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int return_num = 0;
        if (timeSeries==null||timeSeries.length==0){
            return 0;
        }
        for (int i =0;i<timeSeries.length-1;i++){
            if (timeSeries[i+1]-timeSeries[i]<duration){
                return_num = return_num+timeSeries[i+1] - timeSeries[i];
            }else {
                return_num = return_num + duration;
            }
        }
        return return_num;
    }
}
