import java.io.*;

public class BufferedReader{
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String output;
		do{
            output = input.readLine();
            System.out.println(output);
        }while(!output.equals("end"));
    }
}