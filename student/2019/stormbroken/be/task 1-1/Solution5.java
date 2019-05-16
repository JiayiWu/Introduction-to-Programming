package Solution;
import java.util.*;


class Solution5 {
    public int numDecodings(String s) {
    	Solution5 s1 =new Solution5();
        int result = 1;
        int length = 1;
        boolean situation = false;
        List<Integer>          result1 = new ArrayList<Integer>();
        for(int i = 0;i<s.length()-1;i++){
        	int num1 = Integer.valueOf(String.valueOf(s.charAt(i)));
        	int num2 = Integer.valueOf(String.valueOf(s.charAt(i+1)));
        	if(i+1 == s.length()-1) {
        		if(s1.judge(num1,num2)) {
        			length++;
        			result1.add(length);
        		}else {
        			result1.add(length);
        			result1.add(1);
        		}
        	}else {
        		if(s1.judge(num1, num2)) {
        			length++;
        		}else {
        			result1.add(length);
        			length =1  ;
        		}
        	}
        }
        for (int i = 0;i<result1.size();i++) {
        	result = result*s1.calculas(result1.get(i));
        }
        return result;
    }
    public boolean judge(int s1,int s2) {
    	boolean result = false;
    	if(s1==1) {
    		result = true;
    	}else if (s1 == 2){
    		if(1<=s2&&s2<=6) {
    			result = true;
    		}
    	}
    	return result;
    }
    public int calculas(int n) {
    	Solution5 s = new Solution5();
    	int result;
    	if(n==1) {
    		return 1;
    	}else if(n==2){
    		return 2;
    	}else {
    		result = s.calculas(n-1)+s.calculas(n-2);
    		return result;
    	}
    }
   
    public static void main (String[] args) {
    	Solution5 s1 = new Solution5();
    	String s = "2123161";
    	System.out.print(s1.numDecodings(s));
    }
}
