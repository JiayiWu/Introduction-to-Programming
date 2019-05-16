public class Start {
    public static void main(String[] args) {
        //八种数据类型
        byte byte1 = 0;
        short short1 = 0;
        int int1 = 0;
        long long1 = 0L;
        float float1 = 0f;
        double double1 = 0;
        boolean boolean1 = false;
        char char1 = '0';

        System.out.println("byte1:   "+byte1);
        System.out.println("short1:   "+short1);
        System.out.println("int1:   "+int1);
        System.out.println("long1:   "+long1);
        System.out.println("float1:   "+float1);
        System.out.println("double1:   "+double1);
        System.out.println("boolean1:   "+boolean1);
        System.out.println("char1:   "+char1);

        //可表示范围及各自所占的字节数
        System.out.println("byte: "+Byte.MIN_VALUE+"至"+Byte.MAX_VALUE+"  bytes："+Byte.BYTES);

        System.out.println("short: "+Short.MIN_VALUE+"至"+Short.MAX_VALUE+"  bytes："+Short.BYTES);
        System.out.println("int: "+Integer.MIN_VALUE+"至"+Integer.MAX_VALUE+"  bytes："+Integer.BYTES);
        System.out.println("long: "+Long.MIN_VALUE+"至"+Long.MAX_VALUE+"  bytes："+Long.BYTES);
        System.out.println("float: "+Float.MIN_VALUE+"至"+Float.MAX_VALUE+"  bytes："+Float.BYTES);
        System.out.println("double: "+Double.MIN_VALUE+"至"+Double.MAX_VALUE+"  bytes："+Double.BYTES);
        System.out.println("char:   bytes："+Character.BYTES);

    }
}
