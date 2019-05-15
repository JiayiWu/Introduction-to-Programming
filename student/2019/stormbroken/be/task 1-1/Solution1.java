package Solution;

class Solution1 {
	public static void main (String[] args) {
		Solution1 s = new Solution1();
		System.out.print(s.addBinary("1", "1"));
	}
    public String addBinary(String a, String b) {
    	if (a==null||b==null||a.length()==0&&b.length()==0) {
    		return "ERROR";
    	}
    	if (a.length()==0) {
    		return b;
    	}else if(b.length()==0) {
    		return a;
    	}
        int number1 = Integer.valueOf(a);
        int number2 = Integer.valueOf(b);
        int target = 0;
        int base = 1;
        while(number1>0) {
        	target = target +(number1%10)*base;
        	number1 /= 10;
        	base *= 2;
        }
        base = 1;
        while(number2>0) {
        	target = target +(number2%10)*base;
        	number2 /= 10;
        	base *= 2;
        }
        StringBuffer result = new StringBuffer();
        while(target>0) {
        	if((target&1)==1) {
        		result.insert(0,1);
        	}else {
        		result.insert(0,0);
        	}
        	target = target>>1;
        }
        return String.valueOf(result);
    }
}
