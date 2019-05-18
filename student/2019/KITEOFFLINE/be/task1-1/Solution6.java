import java.util.ArrayList;

public class Solution6 {
    public static int findPoisonedDuration(int[] timeSeries, int duration){
        int numTime = timeSeries.length;
        int[] time = new int[timeSeries[numTime-1]+duration];
        for (int k =0; k < time.length; k++){
            time[k] = 0;
        }
        for (int i = 0; i < numTime; i++){
            for (int j = 0; j < duration; j++){
                time[timeSeries[i]+j] = 1;
            }
        }
        int count = 0;
        for (int k = 0; k < time.length; k++){
            if (time[k] == 1){
                count++;
            }
        }
        return count;
    }

    /*public static void main(String[] args) {
        int[] timeSeries = {1,2,4,5,8};
        System.out.println(findPoisonedDuration(timeSeries, 3));
    }*/
}
