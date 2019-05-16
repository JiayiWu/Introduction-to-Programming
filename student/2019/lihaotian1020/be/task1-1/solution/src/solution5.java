class solution5 {
    public int numDecodings(String s) {
        if (s.length()==0){
            return 0;
        }
        int[] count = new int[s.length()];
        if (s.charAt(0)=='0'){
            count[0] = 0;
        }else {
            count[0] = 1;
        }
        if (s.length()==1){
            return count[0];
        }
        if (s.charAt(0)>'0'&&s.charAt(1)>'0'){
            count[1] = count[1]+1;
        }
        if (s.charAt(0)=='1'||s.charAt(0)=='2'&&s.charAt(1)<='6'){
            count[1] = count[1]+1;
        }
        for (int i = 2;i<s.length();i++){
            if (s.charAt(i)!='0'){
                count[i] = count[i] + count[i-1];
            }
            if ((s.charAt(i-1)=='1'||s.charAt(i-1)=='2')&&s.charAt(i)<='6'){
                count[i] = count[i] + count[i-2];
            }
        }
        return count[s.length()-1];
    }
}
