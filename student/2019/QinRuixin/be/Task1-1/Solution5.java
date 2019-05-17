package Task1_1;

class Solution5 {
    public int numDecodings(String s) {
        if(s.length()==0||s.charAt(0)=='0'){
            return 0;
        }
        //第i位有i种解决方式
        int[] result = new int[s.length()+1];
        result[0]=1;
        result[1]=1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='0'||s.charAt(i-1)>'2'){
                    return 0;
                }else {
                    result[i+1] = result[i-1];
                }
            }else if((s.charAt(i-1)=='1'||(s.charAt(i-1)=='2'&&s.charAt(i)<='6'))){
                result[i+1] = result[i]+result[i-1];
            }else {
                result[i+1] += result[i];
            }
        }
        return result[s.length()];

    }
}
