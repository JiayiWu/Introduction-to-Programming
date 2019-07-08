package cn.edu.nju.notebook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Jiayiwu on 19/5/4.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Configuration
//@Configuration用于定义配置类，可替换xml配置文件，
//被注解的类内部包含有一个或多个被@Bean注解的方法，
//这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描
//并用于构建bean定义，初始化Spring容器。
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            //重写父类提供的跨域请求处理的接口
            public void addCorsMappings(CorsRegistry registry) {
                //添加映射路径
                registry.addMapping("/**")
                        //放行哪些原始域
                        .allowedOrigins("*")
                        //是否发送Cookie信息
                        .allowCredentials(true)
                        //放行哪些原始域(请求方式)
                        .allowedMethods("*")
                        //放行哪些原始域(头部信息)
                        .allowedHeaders("*");
            }
        };
    }
}
