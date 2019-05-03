public class ForWhileDo{
    public static void main(String[] args){
        System.out.printf("for: 1+2+3+...+100=%d\n", for1());
        System.out.printf("do-while: 1+2+3+...+100=%d\n", dowhile1());
        System.out.printf("while: 1+2+3+...+100=%d\n", while1());
        System.out.printf("for: 1+3+5+...+101=%d\n", for2());
        System.out.printf("do-while: 1+3+5+...+101=%d\n", dowhile2());
        System.out.printf("while: 1+3+5+...+101=%d\n", while2());
    }
    private static int for1(){
        int sum = 0;
        for(int i = 1; i <= 100; i++){
            sum += i;
        }
        return sum;
    }
    private static int for2(){
        int sum = 0;
        for(int i = 1; i <= 101; i += 2){
            sum += i;
        }
        return sum;
    }
    private static int dowhile1(){
        int sum = 0, i = 1;
        do{
            sum += i;
            i++;
        }while(i <= 100);
        return sum;
    }
    private static int dowhile2(){
        int sum = 0, i = 1;
        do{
            sum += i;
            i += 2;
        }while(i <= 101);
        return sum;
    }
    private static int while1(){
        int sum = 0, i = 1;
        while(i <= 100){
            sum += i;
            i++;
        }
        return sum;
    }
    private static int while2(){
        int sum = 0, i = 1;
        while(i <= 101){
            sum += i;
            i += 2;
        }
        return sum;
    }
}