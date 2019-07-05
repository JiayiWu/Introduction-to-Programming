package cn.edu.nju.notebook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Jiayiwu on 19/1/13.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("cn.edu.nju.notebook"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("南京大学软件学院练习项目记事本API")
                //创建人
                .contact(new Contact("Qin", "", ""))
                //版本号
                .version("2.0")
                //描述
                .description("API 描述，已添加文件夹和待办事项接口及其实现")
                .build();
    }
}
