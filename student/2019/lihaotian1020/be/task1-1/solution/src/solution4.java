class solution4 {
    public int romanToInt(String s) {
        int[] count = new int[256];
        count['I'] = 1;
        count['V'] = 5;
        count['X'] = 10;
        count['L'] = 50;
        count['C'] = 100;
        count['D'] = 500;
        count['M'] = 1000;
        int return_num = 0;
        for(int i = 0;i<s.length();i++){
            if (count[s.charAt(i)]>count[s.charAt(i+1)]||i+1>s.length()){
                return_num = return_num + count[s.charAt(i)];
            }else {
                return_num = return_num - count[s.charAt(i)];
            }
        }
        return return_num;
    }
}