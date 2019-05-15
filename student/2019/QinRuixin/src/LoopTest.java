public class LoopTest {
    public static void main(String[] args) {
        int sum1 = 0;
        int odd1 = 0;
        int sum2 = 0;
        int odd2 = 0;
        int sum3 = 0;
        int odd3 = 0;

        int num = 100;
        while (num >= 1) {
            sum1 += num;
            num--;
        }

        for (int i = 1; i <= 100; i++) {
            sum2 += i;
        }

        num = 100;
        do {
            sum3 += num;
            num--;
        } while (num >= 1);
        System.out.println(String.format("sum1:%d,sum2:%d,sum3:%d", sum1, sum2, sum3));


        num = 101;
        while (num >= 1) {
            odd1 += num;
            num -= 2;
        }

        for (int i = 1; i <= 101; i += 2) {
            odd2 += i;
        }

        num = 1;
        do {
            odd3 += num;
            num += 2;
        } while (num<=101);
        System.out.println(String.format("odd1:%d,odd2:%d,odd3:%d", odd1, odd2, odd3));
    }
}
