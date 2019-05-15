package Solution;

class Solution6 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
    	int result = 0;
    	int pass;
    	boolean situation;
    	for(int i = 0; i<timeSeries.length;i++) {
    		situation = false;
    		pass = 0;
    		if (i == timeSeries.length - 1) {
    			result = result + duration;
    			break;
    		}
    		for(int j = i;j<timeSeries.length;j++) {
    			if(duration<timeSeries[j]-timeSeries[i]||j != i+1) {
    				pass = i;
    				i = j;
    				situation = true;
    				break;
    			}
    		}
    		if (situation) {
    			result = result + duration + timeSeries[i]-timeSeries[pass] ;
    		}else {
    			result = result + duration;
    		}
    		
    	}
    	return result;
    }
    public static void main(String[] args) {
    	Solution6 s = new Solution6();
    	int[] time = {1,7,10};
    	int duration = 3;
    	System.out.print(s.findPoisonedDuration(time, duration));
    }
}
