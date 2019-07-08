package cn.edu.nju.notebook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.net.Socket;

@EnableAspectJAutoProxy//实际上可以不加，默认为开启
@SpringBootApplication
@MapperScan("cn.edu.nju.notebook.dao")
public class NotebookApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(NotebookApplication.class, args);
	}

}
