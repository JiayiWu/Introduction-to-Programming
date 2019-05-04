public class JudgePrimeNum {
    public static void main(String[] args) {
//        6.思考，如何使用循环语句和条件语句来判断一个数是否为素数。[提交代码]
        int num = 743854759;
        boolean sign = true;
        for (int i = 2; i < num; i++){
            if (num % i == 0){
                sign = false;
                System.out.printf("%d不是素数。\n", num);
                break;
            }
        }
        if (sign){
            System.out.printf("%d是素数。", num);
        }
    }
}
