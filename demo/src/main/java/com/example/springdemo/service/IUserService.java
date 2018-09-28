package com.example.springdemo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.model.entity.User;

import java.util.List;

/**
 * @Author: Louis
 * @Date: 9/21/2018
 * @Description:
 */

public interface IUserService extends IService<User> {
    boolean deleteAll();

    User addUser(User user);

    User getById(Long id);

    List<User> listUser();

    public List<User> selectListByWrapper(Wrapper wrapper);
 }
