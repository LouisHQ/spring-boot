package com.example.springdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author: Louis
 * @Date: 9/21/2018
 * @Description:
 */
@Configuration
@ImportResource(locations = {
        "classpath:/configs/spring-mybatis.xml",
        "classpath:/configs/appconfig.xml"
})
public class MybatisPlusConfig {
}
