package com.example.notebook2019.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean

    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            //重写父类提供的跨域请求处理的接口
            public void addCorsMappings(CorsRegistry registry) {
                //映射路径
                registry.addMapping("/**")
                        //原始域
                        .allowedOrigins("*")
                        //是否发送Cookie信息
                        .allowCredentials(true)
                        //请求方式
                        .allowedMethods("*")
                        //头部信息
                        .allowedHeaders("*");
            }
        };
    }

}
