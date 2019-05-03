import java.util.*;
import java.io.*;

public class BubbleSelectionSort{
    public static void main(String[] args){
        List<Integer> arrayList = new ArrayList<>(), arrayList2 = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String[] strList = bufferedReader.readLine().split(" ");
            int n = strList.length;
            for(int i=0; i<n; ++i){
                arrayList.add(Integer.parseInt(strList[i]));
            }
            arrayList2.addAll(arrayList);
            for(int i=0; i<n; ++i){
                int k = i;
                for(int j=i+1; j<n; ++j){
                    if(arrayList.get(j) < arrayList.get(k)){
                        k = j;
                    }
                }
                if(k != i){
                    swap(arrayList, i, k);
                }
            }
            for(int i=0; i<n-1; ++i){
                for(int j=n-1; j>i; --j){
                    if(arrayList2.get(j-1) > arrayList2.get(j)){
                        swap(arrayList2, j - 1, j);
                    }
                }
            }
            System.out.println("SelectionSort: " + arrayList.toString());
            System.out.println("BubbleSort: " + arrayList2.toString());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void swap(List<Integer> arrayList, int i, int j){
        int t = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, t);
    }
}