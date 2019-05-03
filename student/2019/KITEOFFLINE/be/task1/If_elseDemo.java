public class If_elseDemo {
    public static void main(String[] args) {
        int i = 67;
        judgeParity(i);
        int y = 2000;
        judgeYear(y);
    }
    public static void judgeParity(int i){
        if (i % 2 == 1){
            System.out.printf("%d 是奇数。\n", i);
        } else {
            System.out.printf("%d 是偶数。\n", i);
        }
    }
    public static void judgeYear(int y){
        if (y % 4 == 0 && y % 100 != 0){
            System.out.printf("%d年是闰年。\n", y);
        } else if (y % 400 == 0){
            System.out.printf("%d年是闰年。\n", y);
        } else {
            System.out.printf("%d年不是闰年。\n", y);
        }
    }

}
