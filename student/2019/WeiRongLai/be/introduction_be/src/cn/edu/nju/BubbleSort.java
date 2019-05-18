package cn.edu.nju;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        int[] nums = b.getNums();
        int[] aws1 = b.bubbleSort(nums);
        for(int num:nums){
            System.out.print(num+" ");
        }
        int[] aws2 = b.selectionSort(nums);
        for(int num:nums){
            System.out.print(num+" ");
        }
    }

    public int[] getNums() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] temps = reader.readLine().split(" ");
            int len = temps.length;
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = Integer.parseInt(temps[i]);
            }
            return nums;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int[] bubbleSort(int[] nums){
        int len=nums.length;
        int temp;
        for(int j=1;j<len;j++){
            for (int i=0;j+i<len;i++){
                if(nums[i]<nums[i+1]){
                    temp=nums[i+1];
                    nums[i+1]=nums[i];
                    nums[i]=temp;
                }
            }
        }
        return nums;
    }



    public int[] selectionSort(int[] nums) {
        int len=nums.length;
        for(int i=0;i<len-1;i++){
            int k=i;
            for(int j=i+1;j<len;j++){
                if(nums[j]>nums[k]){
                    k=j;
                }
            }
            if(k!=i){
                nums[i]=nums[i]^nums[k];
                nums[k]=nums[i]^nums[k];
                nums[i]=nums[i]^nums[k];
            }
        }

        return nums;
    }
}
