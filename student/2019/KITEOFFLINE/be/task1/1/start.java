public class start {
    public static void main(String[] args) {
        /*
         * 1.新建一个start类，创建一个main方法，java有八种基本数据类型，
         * 在main方法中新建，每一个基本数据类型变量并打印它的值。
         * 自己理解每个类型的长度，可表示的值的范围等信息。[提交代码]
         */

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
