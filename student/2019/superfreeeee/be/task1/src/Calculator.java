public class Calculator{
  public static void main(String[] args) {
    int a = 12, b = 5;
    System.out.println("a + b = " + (a+b));
    System.out.println("a - b = " + (a-b));
    System.out.println("a * b = " + (a*b));
    System.out.println("a / b = " + (a/b));
    System.out.println("a % b = " + (a%b));

    int c;
    System.out.println("\na = " + a);
    c = a++;
    System.out.printf("after c++, a = %d,c = %d\n",a,c);
    System.out.println("a = " + a);
    c = ++a;
    System.out.printf("after c++, a = %d,c = %d\n",a,c);
    
    System.out.println("\ncompare:");
    System.out.println("0 == 1: " + (0 == 1));
    System.out.println("0 == 0: " + (0 == 0));
    System.out.println("0 != 1: " + (0 != 1));
    System.out.println("0 != 0: " + (0 != 0));
    System.out.println("1 > 0: " + (1 > 0));
    System.out.println("1 > 2: " + (1 > 2));
    System.out.println("1 < 0: " + (1 < 0));
    System.out.println("1 < 2: " + (1 < 2));
    System.out.println("1 >= 0: " + (1 >= 0));
    System.out.println("1 >= 1: " + (1 >= 1));
    System.out.println("1 >= 2: " + (1 >= 2));
    System.out.println("1 <= 0: " + (1 <= 0));
    System.out.println("1 <= 1: " + (1 <= 1));
    System.out.println("1 <= 2: " + (1 <= 2));

    getAtimesFour(a);
  }

  private static void getAtimesFour(int a){
    System.out.println("\ntest a*4:");
    System.out.println("a: " + a);
    int result;
    // method1
    result = a*4;
    System.out.println("result: " + result);
    // method2
    result = 0;
    for(int i=0 ; i<4 ; i++){
      result += a;
    }
    System.out.println("result: " + result);
    //method3
    result = a<<2;
    System.out.println("result: " + result);
  }
}