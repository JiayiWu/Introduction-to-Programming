public class start {
    public static void main(String[] args) {
        byte a = 127; //1B, -128 ~ 127
        short b = 32767; //2B, -32768 ~ 32767
        int c = 2147483647; //4B, -2147483648 ~ 2147483647
        long d = 9223372036854775807L; //8B, -9223372036854775808 ~ 9223372036854775807
        float e = 6.6f; //4B, -3.40E+38 ~ 3.40E+38
        double f = 7.7; //8B, -1.79E+308 ~ 1.79E+308
        boolean g = true; //1b
        char h = 'h'; //2B, 0~65535
        System.out.printf("%d\n%d\n%d\n%d\n%f\n%f\n%b\n%c\n", a, b, c, d, e, f, g, h);
    }
}
