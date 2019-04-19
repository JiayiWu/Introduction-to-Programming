import java.io.*;

public class FileInputOutputTest {
    public static void main(String[] args) {
        int[] data = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        try {
            OutputStream ops = new FileOutputStream("temp");
            DataOutputStream dop = new DataOutputStream(ops);
            for (int i = 0; i < 10; ++i) {
                dop.writeInt(data[i]);
            }
            dop.close();
            ops.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream ips = new FileInputStream("temp");
            DataInputStream dis = new DataInputStream(ips);
            for(int i=0; i<10; ++i){
                int tmp = dis.readInt();
                System.out.printf("%d ", tmp);
            }
            dis.close();
            ips.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}