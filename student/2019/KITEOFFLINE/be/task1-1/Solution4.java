public class Solution4 {
    public static int romanToInt(String s){
        int sum = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++){
            if (ch[i] == 'I'){
                if (i < ch.length - 1 && (ch[i + 1] == 'V' || ch[i + 1] == 'X')){
                    sum -= 1;
                } else {
                    sum += 1;
                }
            } else if (ch[i] == 'V'){
                sum += 5;
            } else if (ch[i] == 'X'){
                if (i < ch.length - 1 && (ch[i + 1] == 'L' || ch[i + 1] == 'C')){
                    sum -= 10;
                } else {
                    sum += 10;
                }
            } else if (ch[i] == 'L'){
                sum += 50;
            } else if (ch[i] == 'C'){
                if (i < ch.length - 1 && (ch[i + 1] == 'D' || ch[i + 1] == 'M')){
                    sum -= 100;
                } else {
                    sum += 100;
                }
            } else if (ch[i]== 'D'){
                sum += 500;
            } else {
                sum += 1000;
            }
        }
        return sum;
    }

   /* public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }*/
}
