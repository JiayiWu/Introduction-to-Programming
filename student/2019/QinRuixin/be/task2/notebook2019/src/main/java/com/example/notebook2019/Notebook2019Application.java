package com.example.notebook2019;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.notebook2019.dao")
//记得加上mapper所在的包
public class Notebook2019Application {

    public static void main(String[] args) {
        SpringApplication.run(Notebook2019Application.class, args);
    }

}
