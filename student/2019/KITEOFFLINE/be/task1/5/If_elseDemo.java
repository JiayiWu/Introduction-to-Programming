public class If_elseDemo {
    public static void main(String[] args) {
        /**
         * 5.了解条件语句if...else...语句，判断一个数的奇偶。
         * 思考，如何使用条件语句判断一个用int类型表示的年份是否是闰年。[提交代码]
         */
        int i = 67;
        judgeParity(i);
        int y = 2000;
        judgeYear(y);
    }
    private static void judgeParity(int i){
        if (i % 2 == 1){
            System.out.printf("%d 是奇数。\n", i);
        } else {
            System.out.printf("%d 是偶数。\n", i);
        }
    }
    private static void judgeYear(int y){
        if (y % 4 == 0 && y % 100 != 0){
            System.out.printf("%d年是闰年。\n", y);
        } else if (y % 400 == 0){
            System.out.printf("%d年是闰年。\n", y);
        } else {
            System.out.printf("%d年不是闰年。\n", y);
        }
    }

}
