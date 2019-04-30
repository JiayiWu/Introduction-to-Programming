

public class start {
    public static void main(String[] args)
    {
        byte min_byte=-128;//-2^7
        byte max_byte=127;

        short min_short=-32768;//-2^15
        short max_short=32767;

        int min_int=-2147483648;//-2^31
        int max_int=2147483647;

        long min_long=-9223372036854775808L;//-2^63
        long max_long=9223372036854775807L;

        float test_float=7.777777f;//有效数字为7位

        double test_double=1.12345678912345678;//有效数字为17位

        char a='a';
        char min_char='\0';
        char max_char='\uffff';

        boolean flag=true;
        boolean flag2=false;

        System.out.println(min_byte);
        System.out.println(max_byte);
        System.out.println(min_short);
        System.out.println(max_short);
        System.out.println(min_int);
        System.out.println(max_int);
        System.out.println(min_long);
        System.out.println(max_long);
        System.out.println(test_float);
        System.out.println(test_double);
        System.out.println(flag);
        System.out.println(flag2);
        System.out.println(a);
        System.out.println(min_char);
        System.out.println(max_char);
    }

}
