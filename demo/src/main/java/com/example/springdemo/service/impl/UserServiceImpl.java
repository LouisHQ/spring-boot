package com.example.springdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.model.entity.User;
import com.example.springdemo.mapper.UserMapper;
import com.example.springdemo.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Louis
 * @Date: 9/21/2018
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {
    @Override
    public boolean deleteAll() {
        return retBool(baseMapper.deleteAll());
    }

    @Override
    @Transactional
    public User addUser(User user) {
        int result = baseMapper.insert(user);

        return  user;
    }

    @Override
    public User getById(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<User> listUser() {
        return baseMapper.selectListBySQL();
    }

    @Override
    public List<User> selectListByWrapper(Wrapper wrapper) {
        return  baseMapper.selectListByWrapper(wrapper);
    }
}
