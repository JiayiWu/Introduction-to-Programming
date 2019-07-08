package cn.edu.nju.notebook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.Socket;

@SpringBootApplication
@MapperScan("cn.edu.nju.notebook.dao")
public class NotebookApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(NotebookApplication.class, args);
	}

}
