public class Test5 {
    public static void main(String[] args) {
        int a = 5;
        if(a%2==0){
            System.out.println("偶数");
        }else {
            System.out.println("奇数");
        }

        int year = 2000;
        if(year%4==0){
            if(year%100!=0||year%400==0){
                System.out.println("是闰年");
            }else {
                System.out.println("不是闰年");
            }
        }else {
            System.out.println("不是闰年");
        }
    }
}
