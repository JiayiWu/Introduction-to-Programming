import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if (a == 10) {
            System.out.println(10);
        } else if (a == 20) {
            System.out.println(20);
        } else if (a == 30) {
            System.out.println(30);
        } else if (a == 40) {
            System.out.println(40);
        } else if (a == 50) {
            System.out.println(50);
        }

        switch (a) {
            case 10:
                System.out.println(10);
                break;
            case 20:
                System.out.println(20);
                break;
            case 30:
                System.out.println(30);
                break;
            case 40:
                System.out.println(40);
                break;
            case 50:
                System.out.println(50);
                break;
            default:
                break;
        }
    }
}
