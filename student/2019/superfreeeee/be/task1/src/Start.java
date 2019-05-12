public class Start{
  public static void main(String[] args) {
    byte b = 3;  // 1 byte, -127 ~ 128
    short s = 3;  // 2 byte, -32768 ~ 32767
    int i = 3;  // 4 byte, -2147483648 ~ 2147483647
    long l = 3;  // 8 byte, -9223372036854775808 ~ 9223372036854775807
    float f = 3;  // 4 byte, -3.4E38 ~ 3.4E38
    double d = 3;  // 8 byte, -1.7E308 ~ 1.7E308
    char c = '3';  // 2 byte, 0 ~ 65535
    boolean bool = true;  // 1 byte, true or false

    System.out.println(
      "byte b : " + b + "\n" +
      "short : " + s + "\n" +
      "int : " + i + "\n" +
      "long : " + l + "\n" +
      "float : " + f + "\n" +
      "double : " + d + "\n" +
      "char : " + c + "\n" +
      "boolean : " + bool +"\n"
    );
  }
  
}