package com.example.springdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Louis
 * @Date: 9/11/2018
 * @Description:
 */
@RestController
@Api(tags = "HelloController", description = "Test for launch")
@RequestMapping("/Hello")
public class HelloController {
    @RequestMapping(path = "/index", method = RequestMethod.GET)
    @ApiOperation(value = "附带ID参数的首页", notes = "首页" )
    @ApiImplicitParam(name = "id", value = "唯一标识", required = true, dataType = "String", example = "5")
    public String index(@RequestParam("id") String id) {
        System.out.println("Parameter is "+ id);
        return "Hello world";
    }

    @ApiOperation(value = "没有参数的首页", notes = "首页" )
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
        return "Hello world";
    }
}
