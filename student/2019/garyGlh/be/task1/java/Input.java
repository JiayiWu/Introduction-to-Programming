import javax.print.attribute.standard.OutputDeviceAssigned;
import java.io.*;
public class Input {
    public static String Buffered_read_str()
    {

        System.out.print("Please enter a line:");
        String str=null;
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            str=br.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        return str;
    }

    public static int Buffered_read_int()
    {
        System.out.print("Please enter an integer:");
        String temp=null;
        int res;
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            temp=br.readLine();
            res=Integer.parseInt(temp);

        }catch(IOException e){
            e.printStackTrace();
        }
        try
        {
            res=Integer.parseInt(temp);
        }catch(Exception e){
            return 0;
        }
        return res;
    }

    public static void file_write(String filename,String[] content)
    {
        try{
            OutputStream f = new FileOutputStream(filename);
            OutputStreamWriter writer = new OutputStreamWriter(f,"UTF-8");
            for(int i=0;i<content.length;i++)
            {
                writer.append(content[i]);

                writer.append("\r\n");
            }
            writer.close();
            f.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void file_read(String filename)
    {
        try{
            File f = new File(filename);
            FileInputStream fip = new FileInputStream(f);
            InputStreamReader reader = new InputStreamReader(fip,"UTF-8");

            StringBuffer sb = new StringBuffer();
            while (reader.ready()){
                sb.append((char)reader.read());
            }
            System.out.println(sb.toString());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        //System.out.println(Buffered_read_str());
        //System.out.println(Buffered_read_int());
        String[] content= new String[2];
        content[0]="hello";
        content[1]="67";
        file_write("a.txt",content);
        file_read("a.txt");
    }
}
