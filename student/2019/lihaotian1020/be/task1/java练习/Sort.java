import java.util.Scanner;

public class Sort {
    public static void main(String[] args){
        try{
            Scanner numinput = new Scanner(System.in);
            String numbers = numinput.nextLine();
            String[] snumsarr = numbers.split(" ");
            int[] numarr = new int[snumsarr.length];
            for(int i = 0;i<snumsarr.length;i++){
                numarr[i] = Integer.parseInt(snumsarr[i]);
            }
            for(int i = 0;i<numarr.length-1;i++){   //使用冒泡排序；
                int temp = 0;
                for(int j=i;j<numarr.length-1;j++){
                if (numarr[j]<numarr[j+1]){
                    temp = numarr[j];
                    numarr[j] = numarr[j+1];
                    numarr[j+1] = temp;
                 }
                }
            }
            for(int i = 0;i<numarr.length;i++){
                System.out.print(numarr[i]);
                System.out.print(" ");
            }
            System.out.print("\n");
            int[] numarr0 = {89,79,45,65,32,77,30,37,29,14};
            int mincount = 0;
            int temp = 0;
            for(int i = 0;i<numarr0.length;i++){
                mincount = i;
                for(int j = i + 1;j<numarr0.length;j++){
                    if(numarr0[j]>numarr0[mincount]){
                        mincount = j;
                    }
                }
                temp = numarr0[i];
                numarr0[i] = numarr0[mincount];
                numarr0[mincount]=temp;
            }
            for(int i = 0;i<numarr0.length;i++){
                System.out.print(numarr0[i]);
                System.out.print(" ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
