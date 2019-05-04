import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SortDemo {
    public static void main(String[] args) {
        /*
         * 9.通过控制台读取数据 89 79 45 65 32 77 30 37 29 14
         * 利用冒泡排序、选择排序，将以上整数按从大到小排列。[提交代码]
         */
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String[] tempData = in.readLine().split(" ");
            int[] data = new int[tempData.length];
            for (int i = 0; i < data.length; i++){
                data[i] = Integer.parseInt(tempData[i]);
            }
            System.out.print("The result of bubble sort is " + Arrays.toString(bubbleSort(data)) + ".");
            System.out.println();
            System.out.print("The result of bubble sort is " + Arrays.toString(selectionSort(data)) + ".");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static int[] selectionSort(int[] data){
//        这边循环就是在搞已经排序的和没有排序的
        int[] sortedData = new int[data.length];
        for (int i = 0; i < data.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++){
                if (data[minIndex] > data[j]){
                    minIndex = j;
                }
            }
            int temp = data[i];
            sortedData[i] = data[minIndex];
            data[minIndex] = temp;
        }
        sortedData[data.length - 1] = data[data.length - 1];
        return sortedData;
    }
    public static int[] bubbleSort(int[] data){
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data.length - i - 1; j++){
                if (data[j] > data[j + 1]){
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }
}
