import java.math.*;
public class Judge {
    public boolean is_odd_num(int n)
    {
        if(n%2==1)
            return true;
        else
            return false;
    }
    public boolean is_leap_year(int year)
    {
        if(year%4==0&&year%100!=0)
            return true;
        else if(year%400==0)
            return true;
        return false;
    }
    public boolean is_prime(int n)
    {
        if(n<=1)
            return false;
        if(n==2)
            return true;
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args)
    {
        Judge judger=new Judge();
        System.out.println(judger.is_odd_num(1));
        System.out.println(judger.is_odd_num(2));
        System.out.println(judger.is_leap_year(2000));
        System.out.println(judger.is_leap_year(1998));
        System.out.println(judger.is_leap_year(2016));
        System.out.println(judger.is_prime(13));
        System.out.println(judger.is_prime(25));
        System.out.println(judger.is_prime(14));
        System.out.println(judger.is_prime(1));
        System.out.println(judger.is_prime(0));
    }
}
