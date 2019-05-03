public class start {
    public static void main(String args[]){
        //byte  short int long 为四种整数类型
        byte a = 100;    //byte  -128 ~ 127
        System.out.println(a);
        short b = 30000; //short -32768 ~ 32767
        System.out.println(b);
        int c =  30000000; //int -2^31 ~ 2^31 - 1  -2147483648~2147483647
        System.out.println(c);
        long d = 300000000; //long -2^63 ~2^63 - 1   -9223372036854774808~9223372036854774807
        System.out.println(d);
        //float double 为两种浮点数类型
        float f = 1.234f; //float [-3.40282346638528860e+38 , -1.40129846432481707e-45] ∪ [1.40129846432481707e-45 ~ 3.40282346638528860e+38]
        System.out.println(f);
        double dl = 2.2156; //double [-1.79769313486231570e+308,-4.94065645841246544e-324] ∪  [4.94065645841246544e-324,1.79769313486231570e+308]
        System.out.println(dl);
        //char 为单一的16位Unicode字符
        char letter = 'A';// char \u0000~\uffff
        System.out.println(letter);
        //boolean 表示一位的信息
        boolean count = true;//boolean true false
        System.out.println(count);
    }
}
