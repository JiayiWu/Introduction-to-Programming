import java.lang.reflect.Type;

public class plus {
    public static void main(String[] args){
        int whilesum = 0;
        int i = 0;
        while (i<=100){
            whilesum = whilesum+i;
            i = i + 1;
        }
        i = 0;
        int dosum = 0;
        do{
            dosum = dosum + i;
            i = i + 1;
        }while (i<=100);
        int forsum = 0;
        for(int j = 0;j<101;j++){
            forsum = forsum + j;
        }
        System.out.println(whilesum);
        System.out.println(dosum);
        System.out.println(forsum);
        int oddwhilesum = 0;
        i = 1;
        while (i<=101){
            oddwhilesum = oddwhilesum + i;
            i = i + 2;
        }
        int odddosum = 0;
        i = 1;
        do{
            odddosum = odddosum + i;
            i = i + 2;
        }while (i<=101);
        int oddforsum = 0;
        for(int j =1;j<102;j=j+2){
            oddforsum = oddforsum + j;
        }
        System.out.println(oddwhilesum);
        System.out.println(odddosum);
        System.out.println(oddforsum);
        int[] intarr = {0,1,2,3,4,5};
        String[] strarr = {"Hello",",","world","!"};
        double[] doublearr = {1.2,2.2,2.3,2.4};
        for(int t = 0;t < 6;t++){
            System.out.print(intarr[t]);
            System.out.print(" ");
        }
        System.out.print("\n");
        for(int t = 0;t < 4;t++){
            System.out.print(strarr[t]);
        }
        System.out.print("\n");
        for (int t = 0;t < 4;t++){
            System.out.print(doublearr[t]);
            System.out.print(" ");
        }
    }
}
