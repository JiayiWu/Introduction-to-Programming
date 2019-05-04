import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedreaderDemo {
    public static void main(String[] args) {
        /*
         * 8.了解BufferredReader，使用BufferedReader从控制台读取输入。
         * 了解FileInputStream、FileOutputSteam，
         * 读取文件、写文件。思考在读取文件的时候如果没有读到文件，会发生什么？
         * 连接Java 异常 try…catch机制。[提交代码和Readme.md文件]
         */
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = in.readLine();
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
