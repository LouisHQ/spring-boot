package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Louis
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.example.springdemo",
        "com.mybatis.plus.actable.manager.*"
})
public class SpringDemoApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        System.out.println("Initializing..............................");
        return application.sources(SpringDemoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
        System.out.println("Launched successfully......................");
        System.out.println("Try API document address: http://localhost:8080/spring-demo/swagger-ui.html.....................");
    }
}
