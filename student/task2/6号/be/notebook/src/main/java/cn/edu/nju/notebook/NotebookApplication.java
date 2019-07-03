package cn.edu.nju.notebook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.Socket;
import java.net.SocketAddress;

@SpringBootApplication
@MapperScan("cn.edu.nju.notebook.dao")
public class NotebookApplication {

	public static void main(String[] args)
	{
//		Socket socket = new Socket();
//		socket.connect();
		SpringApplication.run(NotebookApplication.class, args);

	}

}
