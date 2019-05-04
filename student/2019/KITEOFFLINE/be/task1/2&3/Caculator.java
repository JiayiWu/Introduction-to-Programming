public class Caculator {
    public static void main(String[] args) {
        /**
         * 2.新建一个Caculator类，创建一个main方法，
         * 定义两个int类型的变量a = 12 , b = 5，计算下列表达式的值：
         * a+b，a-b ，a * b， a／b，a%b ，思考所得的值是否你想象的一样，
         * 定义int类型的变量c,计算并思考c=a++ ，c=++a之间的区别。
         * 尝试使用关系运算符 == ，!= > ，< ，>= ，<=。 [提交代码]
         */
        int a = 12;
        int b = 5;
        System.out.printf("a + b = %d\na - b = %d\na * b = %d\na / b = %d\na %% b = %d\n", a+b, a-b, a*b, a/b, a%b);
        int c;
        c = a++;
        System.out.printf("c = %d\n", c);
        System.out.printf("a = %d\n", a);
        c = ++a;
        System.out.printf("c = %d\n", c);
        System.out.printf("a = %d\n", a);

//      3.拓展Caculator扩展，要得到a*4的值，
//      除了直接将a的值乘4还有什么办法，思考两种办法区别。[提交代码]
        a = 12;
        a = a << 2;
        System.out.println(a);

    }
}
