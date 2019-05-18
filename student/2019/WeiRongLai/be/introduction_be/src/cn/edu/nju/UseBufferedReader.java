package cn.edu.nju;
import java.io.*;
public class UseBufferedReader {
    public static void main(String[] args){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line=reader.readLine();
            String[] aList=line.split(" ");
            int sum=0;
            for(String temp:aList){
                sum+=Integer.parseInt(temp);
            }
            System.out.println(sum);

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

}
