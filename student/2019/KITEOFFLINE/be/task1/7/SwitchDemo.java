import java.util.Scanner;

public class SwitchDemo {
    public static void main(String[] args) {
// 7.使用if...else if...else，输入为10，20，30，40，50中的一个，
//   如何判断他们的值。用switch优化多重的判断。[提交代码]
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        System.out.println("use if_elseFunction");
        if_elseFunction(inputNum);
        System.out.println("use switch");
        switchFunction(inputNum);
    }
    private static void if_elseFunction(int inputNum){
        if (inputNum == 10){
            System.out.println("enter 10");
        } else if (inputNum == 20){
            System.out.println("enter 20");
        } else if (inputNum == 30){
            System.out.println("enter 30");
        } else if (inputNum == 40){
            System.out.println("enter 40");
        } else if (inputNum == 50){
            System.out.println("enter 50");
        } else{
            System.out.println("wrong");
        }
    }
    private static void switchFunction(int inputNum){
        switch (inputNum) {
            case 10:
                System.out.println("enter 10");
                break;
            case 20:
                System.out.println("enter 20");
                break;
            case 30:
                System.out.println("enter 30");
                break;
            case 40:
                System.out.println("enter 40");
                break;
            case 50:
                System.out.println("enter 50");
                break;
            default:
                System.out.println("wrong");
        }
    }
}
