public class Solution7 {
    //递归版本，代码简单，速度慢
    public int Fib(int n) {
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        else
            return Fib(n-1)+Fib(n-2);
    }
    //循环版本，速度快
    public int Fib1(int n){
        int res=1;
        int temp=0;
        if(n==0)
            return temp;
        else if(n==1)
            return res;
        else{
            for(int i=2;i<=n;i++)
            {
                res=res+temp;
                temp=res-temp;
            }
        }
        return res;
    }

}
