public class Solution1 {
    private long stringToLong(String s) {
        long a = 0;
        for(int i=0; i<s.length(); ++i) {
            a = a * 2 + s.charAt(i) - '0';
        }
        return a;
    }
    public String longToString(long a) {
        String s = "";
        while(a > 0) {
            s = Long.toString(a % 2) + s;
            a >>= 1;
        }
        return s;
    }
    public String addBinary(String a, String b) {
        return longToString(stringToLong(a) + stringToLong(b));
    }
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.addBinary("0", "10"));
    }
}