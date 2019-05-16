import java.util.ArrayList;
import java.util.Arrays;

public class Solution5 {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')
            return 0;

        if(s.length()==1){
            return 1;
        }

        int[] res = new int[s.length()];
        res[0]=1;

        if(s.charAt(1)=='0')//若第二位为0
        {
            if(s.charAt(0)=='1'||s.charAt(0)=='2')
                res[1]=1;
            else
                return 0;
        }
        else if(s.charAt(1)=='1'){
            if(s.charAt(0)=='1'||s.charAt(0)=='2')
                res[1]=2;
            else
                res[1]=1;
        }
        else if(s.charAt(1)=='2'){
            if(s.charAt(0)=='1'||s.charAt(0)=='2')
                res[1]=2;
            else
                res[1]=1;
        }
        else if(s.charAt(1)>='3'&&s.charAt(1)<='6')
        {
            if(s.charAt(0)=='1'||s.charAt(0)=='2')
                res[1]=2;
            else
                res[1]=1;
        }
        else
        {
            if(s.charAt(0)=='1')
                res[1]=2;
            else
                res[1]=1;
        }

        for(int i=2;i<s.length();i++){
            if(s.charAt(i)=='0')
            {
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2')
                    res[i]=res[i-2];
                else
                    return 0;
            }

            else if(s.charAt(i)>='1'&&s.charAt(i)<='6'){
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2')
                    res[i]=res[i-1]+res[i-2];
                else
                    res[i]=res[i-1];
            }
            else{
                if(s.charAt(i-1)=='1')
                    res[i]=res[i-1]+res[i-2];
                else
                    res[i]=res[i-1];
            }
        }
        return res[s.length()-1];
    }
    public static void main(String[] args){
        Solution5 test = new Solution5();
        System.out.println(test.numDecodings("100"));
    }
}
