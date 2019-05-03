public class Start{
    public static void main(String[] args){
        byte a = 1; //1B, -128~127
        short b = 2; //2B, -32768~32767
        int c = 3; //4B, -2147483648~2147483647
        long d = 4L; //8B, -9223372036854775808~9223372036854775807
        float e = 5.0f; //4B, 1.4E-45~3.4028235E38
        double f = 6.0; //8B, 4.9E-324~1.7976931348623157E308
        boolean g = false; //1b
        char h = 'h'; //2B, 0~65535
        System.out.printf("%d %d %d %d %f %f %b %c", a, b, c, d, e, f, g, h);
    }
}