package cn.edu.nju;

public class Start {
    public static void main(String [] args){
        boolean bl=true;
        byte b=1;
        short s=3;
        int i=4;
        long l=6;
        float f=12.4f;
        double d=23.4;

        System.out.println("MAX_byte:"+Byte.MAX_VALUE+'\n'+"MIN_byte:"+Byte.MIN_VALUE
                +'\n'+"variable="+b);
        System.out.println("MAX_short:"+Short.MAX_VALUE+'\n'+"MIN_short:"+Short.MIN_VALUE
                +'\n'+"variable="+s);
        System.out.println("MAX_long:"+Long.MAX_VALUE+'\n'+"MIN_long:"+Long.MIN_VALUE
                +'\n'+"variable="+l);
        System.out.println("MAX_int:"+Integer.MAX_VALUE+'\n'+"MIN_int:"+Integer.MIN_VALUE
                +'\n'+"variable="+i);
        System.out.println("MAX_long:"+Long.MAX_VALUE+'\n'+"MIN_long:"+Long.MIN_VALUE
                +'\n'+"variable="+l);
        System.out.println("MAX_float:"+Float.MAX_VALUE+'\n'+"MIN_float:"+Float.MIN_VALUE
                +'\n'+"variable="+f);
        System.out.println("MAX_double:"+Double.MAX_VALUE+'\n'+"MIN_double:"+Double.MIN_VALUE
                +'\n'+"variable="+d);
        System.out.println("boolen:"+bl);
    }
}
