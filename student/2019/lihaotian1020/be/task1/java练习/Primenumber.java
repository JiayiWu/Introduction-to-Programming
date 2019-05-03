import java.util.Scanner;

public class Primenumber {
    public static void main(String[] args){
        int count = 0;
        try {
            Scanner nums = new Scanner(System.in);
            int number = nums.nextInt();
            for(int i = 1; i<=Math.sqrt(number);i++){
                if (number%i==0){
                    count = count + 1;
                }
            }
            if(count==1){
                System.out.println("This is a prime number.");
            }else{
                System.out.println("This is not a prime number.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
