package com.example.springdemo.mapper;

/**
 * @Author: Louis
 * @Date: 9/21/2018
 * @Description:
 */

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.springdemo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * User 表数据库控制层接口
 */
public interface UserMapper extends SuperMapper<User> {

    /**
     * 自定义注入方法
     */
    int deleteAll();

    @Select("SELECT test_id AS id, tenant_id as tenantId, name, age, test_type, test_date, role, phone  FROM demo_user")
    List<User> selectListBySQL();

    List<User> selectListByWrapper(@Param("ew") Wrapper wrapper);

}