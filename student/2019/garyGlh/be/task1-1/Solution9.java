public class Solution9 {
    //递归版本，代码简单，速度慢
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        else
            return climbStairs(n-1)+climbStairs(n-2);
    }
    //循环版本，速度快
    public int climbStairs1(int n){
        int res=2;
        int temp=1;
        if(n==0)
            return 0;
        else if(n==1)
            return temp;
        else if(n==2)
            return res;
        else{
            for(int i=3;i<=n;i++)
            {
                res=res+temp;
                temp=res-temp;
            }
        }
        return res;
    }
    public static void main(String[] args)
    {
        Solution9 test = new Solution9();
        long starttime = System.currentTimeMillis();
        System.out.println(test.climbStairs(44));
        long endtime = System.currentTimeMillis();
        System.out.println(endtime-starttime);
        starttime = System.currentTimeMillis();
        System.out.println(test.climbStairs1(44));
        endtime = System.currentTimeMillis();
        System.out.println(endtime-starttime);
    }
}
