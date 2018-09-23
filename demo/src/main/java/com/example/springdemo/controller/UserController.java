package com.example.springdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springdemo.entity.enums.AgeEnum;
import com.example.springdemo.entity.User;
import com.example.springdemo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @Author: Louis
 * @Description:
 */
@RestController
@Api(tags = "UserController", description = "CURD in mybatis")
@RequestMapping("/User")
public class UserController extends ApiController {
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "根据ID获取用户", notes = "首页")
    @ApiImplicitParam(name = "id", value = "唯一标识", required = true, dataType = "String", example = "5")
    @GetMapping(path = "/")
    public User getById(@RequestParam("id") Long id) {
        return userService.getById(id);
    }

    @ApiOperation(value = "添加新用户")
    @PostMapping(path = "/add")
    public User add(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping(path = "/list")
    @ApiOperation(value = "获取所有用户")
    public Object list() {
        return userService.listUser();
    }

    @GetMapping("/select_wrapper")
    public Object getUserByWrapper() {
        return userService.selectListByWrapper(new QueryWrapper<User>()
                .lambda().like(User::getName, "毛")
                .or(e -> e.like(User::getName, "张")));
    }

    /**
     * 增删改查 CRUD
     */
    @GetMapping("/test2")
    @ApiOperation(value = "数据库CURD")
    public User test2() {
//        System.err.println("删除一条数据：" + userService.removeById(1L));
        System.err.println("deleteAll：" + userService.deleteAll());
        System.err.println("插入一条数据：" + userService.save(new User("张三", AgeEnum.TWO, 1)));
        User user = new User("张三", AgeEnum.TWO, 1);
        boolean result = userService.save(user);
        // 自动回写的ID
        String id = user.getId();
        System.err.println("插入一条数据：" + result + ", 插入信息：" + user.toString());
        System.err.println("查询：" + userService.getById(id).toString());
        System.err.println("更新一条数据：" + userService.updateById(new User(UUID.randomUUID().toString(), "三毛", AgeEnum.ONE, 1)));
        for (int i = 0; i < 5; ++i) {
            userService.save(new User("张三" + i, AgeEnum.ONE, 1));
        }
        IPage<User> userListPage = userService.page(new Page<User>(1, 5), new QueryWrapper<User>());
        System.err.println("total=" + userListPage.getTotal() + ", current list size=" + userListPage.getRecords().size());

        userListPage = userService.page(new Page<User>(1, 5), new QueryWrapper<User>().orderByDesc("name"));
        System.err.println("total=" + userListPage.getTotal() + ", current list size=" + userListPage.getRecords().size());
        return userService.getById(id);
    }
}
