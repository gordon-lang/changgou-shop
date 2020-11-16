package com.changgou;

 import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient//开启eurake客户端
@MapperScan( basePackages = "com.changgou.dao" )
@EnableSwagger2
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }
}
