public class Solution5 {
    public static int numDecodings(String s){
        char[] ch = s.toCharArray();
        int single = 1, sum = 1, temp;
        if (ch[0] == '0'){
            return 0;
        }
        for (int i = 1; i < ch.length; i++){
            if (ch[i] != '0'){
                if (((ch[i-1] - '0')*10 + ch[i] - '0') <= 26){
                    temp = single;
                    single = sum;
                    sum += temp;
                } else {
                    single = sum;
                }
            } else {
                if (((ch[i-1] - '0')*10 + ch[i] - '0') <= 26){
                    temp = single;
                    single = 0;
                    sum = temp;
                } else {
                    return 0;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("01220321"));
    }
}
