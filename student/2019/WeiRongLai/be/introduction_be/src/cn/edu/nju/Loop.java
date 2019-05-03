package cn.edu.nju;

public class Loop {
    public static void main(String[] args){
        //caculate the sum of 1 to 100 with while
        int i = 1;
        int sumWhile = 0;
        while(i < 101){
            sumWhile+=i;
            i++;
        }
        i=1;
        int sumWhile1=0;
        while(i < 101){
            sumWhile1+=i;
            i+=2;
        }

        //caculate the sum of 1 to 100 with do_while
        i=1;
        int sumDo = 0;
        do{
            sumDo+=i;
            i++;
        }while (i<101);
        i=1;
        int sumDo1=0;
        do{
            sumDo1+=i;
            i+=2;
        }while (i<101);

        // caculate the sum of 1 to 100 with for
        int sumFor1=0;
        int sumFor=0;
        for(i=1;i<101;i++){
            sumFor+=i;
        }
        for(i=1;i<101;i+=2){
            sumFor1+=i;
        }

        System.out.println("while:"+sumWhile +" and "+sumWhile1);
        System.out.println("for:"+sumFor+" and "+sumFor1);
        System.out.println("do_while:"+sumDo+" and "+sumDo1);

        int[] anArray={1,2,3,4,5,6,7};
        for(int temp:anArray){
            System.out.println(temp);
        }
    }
}
