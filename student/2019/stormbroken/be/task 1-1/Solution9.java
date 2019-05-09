package Solution;

class Solution9 {
    public int climbStairs(int n) {
    	Solution9 s = new Solution9();
    	int result;
    	if(n==1) {
    		return 1;
    	}else if(n==2){
    		return 2;
    	}else {
    		result = s.climbStairs(n-1)+s.climbStairs(n-2);
    		return result;
    	}
       
   }
    public static void main (String[] args) {
    	Solution9 s = new Solution9();
    	int n = 2;
    	System.out.print(s.climbStairs(n));
    }
}
