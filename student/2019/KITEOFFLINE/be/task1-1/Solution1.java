public class Solution1 {
    public static String addBinary(String a, String b) {
        String result = "";
        int index_a = a.length() - 1;
        int index_b = b.length() - 1;
        int temp = 0;
        int jump = 0;
        while (index_a >= 0 || index_b >= 0) {
            int tempA, tempB;
            if (index_a >= 0){
                tempA = a.charAt(index_a) - '0';
            } else {
                tempA = 0;
            }
            if (index_b >= 0){
                tempB = b.charAt(index_b) - '0';
            } else {
                tempB = 0;
            }
            temp = tempA + tempB + jump;
            result = temp % 2 + result;
            jump = temp / 2;
            index_a--;
            index_b--;
        }
        if (jump == 1) {
            result = jump + result;
        }
        return result;
    }

/*    public static void main(String[] args) {
        String ee = addBinary("1101010101", "1111011");
        System.out.println(ee);
    }*/
}
