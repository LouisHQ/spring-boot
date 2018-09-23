package com.example.springdemo.controller;

import com.example.springdemo.SpringDemoApplicationTestsBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @Author: Louis
 * @Date: 9/14/2018
 * @Description:
 */

public class HelloControllerTest extends SpringDemoApplicationTestsBase {

    @Autowired
    private HelloController controller;

    @Test
    public void index() {
        String body = this.restTemplate.getForObject("/Hello/index?id=5", String.class);
        assertThat(body).isEqualTo("Hello world");
    }

    @Test
    public void index2() {
        String body = this.restTemplate.getForObject("/Hello/index?id=6", String.class);
        assertThat(body).isEqualTo("Hello world");
    }

    @Test
    @Parameters({"a","b"})
    public void say(String a, String b) {
        System.out.println(a);
        System.out.println(b);
    }
}
