import java.util.Scanner;
public class Solution4 {
    public int romanToInt(String s) {
        int[] positive = {0,0,0,0,0,0,0};//分别记录I,V,X,L,C,D,M
        int[] negative ={0,0,0};//分别记录I,X,C
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)=='I'){
                if(s.charAt(i+1)=='V'||s.charAt(i+1)=='X'){
                    negative[0]++;
                }
                else{
                    positive[0]++;
                }
            }
            else if(s.charAt(i)=='V'){
                positive[1]++;
            }
            else if(s.charAt(i)=='X'){
                if(s.charAt(i+1)=='L'||s.charAt(i+1)=='C'){
                    negative[1]++;
                }
                else{
                    positive[2]++;
                }
            }
            else if(s.charAt(i)=='L'){
                positive[3]++;
            }
            else if(s.charAt(i)=='C'){
                if(s.charAt(i+1)=='D'||s.charAt(i+1)=='M'){
                    negative[2]++;
                }
                else{
                    positive[4]++;
                }
            }
            else if(s.charAt(i)=='D'){
                positive[5]++;
            }
            else if(s.charAt(i)=='M'){
                positive[6]++;
            }
        }
        if(s.charAt(s.length()-1)=='I')
            positive[0]++;
        else if(s.charAt(s.length()-1)=='V')
            positive[1]++;
        else if(s.charAt(s.length()-1)=='X')
            positive[2]++;
        else if(s.charAt(s.length()-1)=='L')
            positive[3]++;
        else if(s.charAt(s.length()-1)=='C')
            positive[4]++;
        else if(s.charAt(s.length()-1)=='D')
            positive[5]++;
        else if(s.charAt(s.length()-1)=='M')
            positive[6]++;
        return positive[0]-negative[0]+5*positive[1]+10*(positive[2]-negative[1])+50*positive[3]+100*(positive[4]-negative[2])+500*positive[5]+1000*positive[6];
    }
    public static void main(String[] args)
    {
        Solution4 test = new Solution4();
        Scanner input = new Scanner(System.in);
        String a = "";
        while(true) {
            a=input.next();
            System.out.println(test.romanToInt(a));
        }
        }
}
