public class Switch{
    public static void main(String[] args){
        int a = 20;
        if(a == 10){
            System.out.printf("10");
        }
        else if(a == 20){
            System.out.printf("20");
        }
        else if(a == 30){
            System.out.printf("30");
        }
        else if(a == 40){
            System.out.printf("40");
        }
        else if(a == 50){
            System.out.printf("50");
        }
        System.out.printf("\n");
        switch(a){
            case 10:
                System.out.printf("10");
                break;
            case 20:
                System.out.printf("20");
                break;
            case 30:
                System.out.printf("30");
                break;
            case 40:
                System.out.printf("40");
                break;
            case 50:
                System.out.printf("50");
                break;
        }
    }
}