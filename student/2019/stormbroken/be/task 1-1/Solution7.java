package Solution;

class Solution7 {
    public int fib(int N) {
    	Solution7 s = new Solution7();
    	int result;
    	if(N==1) {
    		return 1;
    	}else if(N==0){
    		return 0;
    	}else {
    		result = s.fib(N-1)+s.fib(N-2);
    		return result;
    	}
      
  }
    public static void main(String[] args) {
    	Solution7 s = new Solution7();
    	int N = 4;
    	System.out.print(s.fib(N));
    }
}
