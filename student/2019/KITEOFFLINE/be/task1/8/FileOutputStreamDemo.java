import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutputStreamDemo {
    /*
     * 8.了解BufferredReader，使用BufferedReader从控制台读取输入。
     * 了解FileInputStream、FileOutputSteam，
     * 读取文件、写文件。思考在读取文件的时候如果没有读到文件，会发生什么？
     * 连接Java 异常 try…catch机制。[提交代码和Readme.md文件]
     */
    public static void main(String[] args) {
        try {
            String locate = "c:\\users\\mmm\\desktop\\fileoutpustreamdemo.txt";
            FileOutputStream fiout = new FileOutputStream(locate);
            byte[] b = {'I', 'l', 'o', 'v', 'e', 'j', 'c', 'c'};
            fiout.write(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
