import java.util.ArrayList;import  java.util.Scanner;
public class Solution1 {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();

        String temp;
        //a为较长的，b为较短的
        if(a.length()<b.length())
        {
            temp=a;
            a=b;
            b=temp;
        }

        int carry=0;
        int index_a=a.length()-1;
        int index_b=b.length()-1;
        for(;index_b>=0;index_a--,index_b--)
        {
            if(a.charAt(index_a)=='0'&&b.charAt(index_b)=='0')
            {
                if(carry==0)
                    res.insert(0,'0');
                else
                {
                    carry=0;
                    res.insert(0,'1');
                }
            }
            else if(a.charAt(index_a)=='1'&&b.charAt(index_b)=='1')
            {
                if(carry==0)
                {
                    carry=1;
                    res.insert(0,'0');
                }
                else
                {
                    carry=1;
                    res.insert(0,'1');
                }
            }
            else//其中有一个1，一个0
            {
                if(carry==0)
                {
                    res.insert(0,'1');
                }
                else
                {
                    carry=1;
                    res.insert(0,'0');
                }
            }
        }

        if(index_a==-1)//若a也计算完
        {
            if(carry==1)
                res.insert(0,'1');
        }
        else
        {
            for(;index_a>=0;index_a--)
            {
                if(carry==0)
                {
                    res.insert(0,a.charAt(index_a));
                }
                else//carry==1
                {
                    if(a.charAt(index_a)=='0')
                    {
                        carry=0;
                        res.insert(0,'1');
                    }
                    else
                    {
                        carry=1;
                        res.insert(0,'0');
                    }
                }
            }
            if(carry==1)
                res.insert(0,'1');
        }


        return res.toString();
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the 1st number: ");
        String testa = input.next();
        System.out.print("Enter the 2nd number: ");
        String testb = input.next();
        Solution1 test = new Solution1();
        System.out.println(test.addBinary(testa,testb));
    }
}
