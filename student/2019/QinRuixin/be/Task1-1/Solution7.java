package Task1_1;

class Solution7 {
    public int fib(int N) {
        if(N==0){
            return 0;
        }else if(N==1){
            return 1;
        }
        int a = 0;
        int b = 1;
        int result = 0;
        int i = 1;
        do{
            result = a+b;
            a = b;
            b = result;
            i++;
        }while (i < N);

        return result;
    }
}

