class solution1 {
    public String addBinary(String a,String b) {
        //考虑进位 当前位置
        //补全位数
        while (a.length()!=b.length()){
            if (a.length()<b.length()){
                a = "0" + a;
            }else {
                b = "0" + b;
            }
        }
        String return_str = "";
        int numplus = 0;// 进位判断
        int temp;   //当前位置最终值
        for (int i = a.length() -1;i>=0;i--){
            temp = a.charAt(i)+b.charAt(i)-'0'-'0'+numplus;
            if (temp>=2){
                temp = temp-2;
                numplus = 1;
            }else {
                numplus = 0;
            }
            return_str = String.valueOf(temp) + return_str;
        }
        if (numplus==1){
            return_str = "1" + return_str;
        }
        return return_str;
    }

}
