package Solution;

class Solution4 {
    public int romanToInt(String s) {
        int[] result = new int[s.length()];
        int resultnumber = 0;
        for (int i = 0;i<s.length();i++) {
        	switch(s.charAt(i)) {
        	case 'I':
        		result[i]=1;
        		break;
        	case 'V':
        		result[i]=5;
        		break;
        	case 'X':
        		result[i]=10;
        		break;
        	case 'L':
        		result[i]=50;
        		break;
        	case 'C':
        		result[i]=100;
        		break;
        	case 'D':
        		result[i]=500;
        		break;
        	case 'M':
        		result[i]=1000;
        		break;
        	}
        }
        for(int i =0;i<s.length()-1;i++) {
        	if(result[i]<result[i+1]){
        		resultnumber = resultnumber - result[i];
        	}else {
        		resultnumber = resultnumber + result[i];
        	}	
        }
        resultnumber = resultnumber + result[s.length()-1];
        
        return resultnumber;
    }
    public static void main(String[] args) {
    	Solution4 s1 = new Solution4();
    	String s = "MCMXCIV";
    	System.out.print(s1.romanToInt(s));;
    }
}
