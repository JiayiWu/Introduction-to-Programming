public class WhileDowhileFor {
    public static void main(String[] args) {
        int i = 1;
        int sum = 0;
        while(i <= 100){
            sum += i;
            i++;
        }
        System.out.printf("1 to 101 while demo1 result is %d.\n", sum);
        sum = 0;
        i = 1;
        do{
            sum += i;
            i++;
        }while(i <= 100);
        System.out.printf("1 to 101 do_while demo1 result is %d.\n", sum);
        sum = 0;
        for(i = 0; i <= 100; i++){
            sum += i;
        }
        System.out.printf("1 to 101 for demo1 result is %d.\n", sum);
        i = 1;
        sum = 0;
        while (i <= 101){
            sum += i;
            i = i + 2;
        }
        System.out.printf("1 to 100 while demo2 result is %d.\n", sum);
        i = 1;
        sum = 0;
        do {
            sum += i;
            i = i + 2;
        } while (i <= 101);
        System.out.printf("1 to 100 do_while demo2 result is %d.\n", sum);
        sum = 0;
        for (i = 1; i <= 101; i = i + 2){
            sum += i;
        }
        System.out.printf("1 to 100 for demo2 result is %d.\n", sum);

    }
}