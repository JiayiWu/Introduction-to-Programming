import java.util.Scanner;

public class Judge_five_number {
    public static void main(String[] args){
        try{
            Scanner num = new Scanner(System.in);
            int number = num.nextInt();
            if(number==10){
                System.out.println("The number is 10.");
            }else if(number==20){
                System.out.println("The number is 20.");
            }else if(number==30){
                System.out.println("The number is 30.");
            }else if(number==40){
                System.out.println("The number is 40.");
            }else if(number==50){
                System.out.println("The number is 50.");
            }else{
                System.out.println("Can not be identified.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            Scanner nums = new Scanner(System.in);
            int numbers = nums.nextInt();
            switch (numbers){
                case 10:System.out.println("The number is 10.");break;
                case 20:System.out.println("The number is 20.");break;
                case 30:System.out.println("The number is 30.");break;
                case 40:System.out.println("The number is 40.");break;
                case 50:System.out.println("The number is 50.");break;
                default:System.out.println("Can not be identified.");break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
