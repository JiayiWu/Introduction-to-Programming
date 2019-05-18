import java.util.Scanner;

public class Test9 {
    public static void main(String[] args) {
        //输入89 79 45 65 32 77 30 37 29 14
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strings = line.split(" ");
        int[] array = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }

        //冒泡排序
        bubbleSort(array);

        //选择排序
        selectSort(array);
    }

    private static void selectSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int maxIdx = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[maxIdx]<array[j]){
                    maxIdx =j;
                }
            }
            if(maxIdx==i){
                continue;
            }
            int temp = array[maxIdx];
            array[maxIdx] =array[i];
            array[i]=temp;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
            if(i==array.length-1){
                System.out.println();
            }
        }
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if(array[j]<array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
            if(i==array.length-1){
                System.out.println();
            }
        }
    }
}
