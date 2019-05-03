import java.io.*;
import java.util.ArrayList;
public class Sort {

    static int[] Bubble_Sort(int[] nums)
    {
        int temp;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length-1-i;j++)
            {
                if(nums[j]<nums[j+1]){
                    temp=nums[j+1];
                    nums[j+1]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        return nums;
    }
    static int[] Select_Sort(int[] nums)
    {
        int index_of_max;
        int temp;
        for(int i=0;i<nums.length-1;i++)
        {
            index_of_max=i;
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[j]>nums[index_of_max])
                    index_of_max=j;
            }
            temp=nums[i];
            nums[i]=nums[index_of_max];
            nums[index_of_max]=temp;
        }
        return nums;
    }

    static int[] input_array()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please input the nums:");
        String temp= null;
        try{
            temp=br.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        String[] s = temp.split(" ");

        int[] a = new int[s.length];
        for(int j=0;j<s.length;j++)
        {
            a[j]=Integer.parseInt(s[j]);
        }
        return a;
    }

    static void print_array(int[] nums)
    {
        System.out.println("index num");
        for(int i=0;i<nums.length;i++)
            System.out.printf("%-6d%d\n",i,nums[i]);
    }

    public static void main(String[] args) {
        int[] test=input_array();
        print_array(test);
        print_array(Bubble_Sort(test));
        print_array(Select_Sort(test));
    }

}
