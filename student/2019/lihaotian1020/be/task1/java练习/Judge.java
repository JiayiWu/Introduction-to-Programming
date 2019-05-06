import java.util.Scanner;

public class Judge {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            int num = scan.nextInt();
            if (num % 2 == 1) {
                System.out.println("This is an odd");
            } else {
                System.out.println("This is an even");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Scanner Scanyear = new Scanner(System.in);
            int year = Scanyear.nextInt();
            if (year%4==0&&year%100!=0||year%400==0){
                System.out.println("This is a leap year.");
            }else {
                System.out.println("This is not a leap year.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
