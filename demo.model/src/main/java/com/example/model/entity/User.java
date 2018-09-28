package com.example.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.model.entity.enums.AgeEnum;
import com.example.model.entity.enums.PhoneEnum;
import com.mybatis.plus.actable.annotation.Column;
import com.mybatis.plus.actable.annotation.Table;
import com.mybatis.plus.actable.constants.MySqlTypeConstant;

import java.util.Date;

/**
 * @Author: Louis
 * @Date: 9/20/2018
 * @Description:
 */
@TableName("demo_user")
@Table(name = "demo_user")
public class User extends SuperEntity<User> {

    /**
     * 名称
     */
    @Column(name ="name",type = MySqlTypeConstant.TEXT, length = 50)
    private String name;
    /**
     * 年龄
     */
    @Column(name ="age",type = MySqlTypeConstant.INT)
    private AgeEnum age;
    /**
     * 这里故意演示注解可无
     */
    @TableField("test_type")
    @Column(name ="test_type",type = MySqlTypeConstant.INT)
    @TableLogic
    private Integer testType;

    /**
     * 测试插入填充
     */
    @TableField(fill = FieldFill.INSERT)
    @Column(name ="test_date",type = MySqlTypeConstant.DATETIME)
    private Date testDate;

    @Column(name ="role",type = MySqlTypeConstant.BIGINT)
    private Long role;

    @Column(name ="phone",type = MySqlTypeConstant.TEXT)
    private PhoneEnum phone;

    public User() {
    }

    public User(String id, String name, AgeEnum age, Integer testType) {
        this.setId(id);
        this.name = name;
        this.age = age;
        this.testType = testType;
    }

    public User(String name, AgeEnum age, Integer testType) {
        this.name = name;
        this.age = age;
        this.testType = testType;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AgeEnum getAge() {
        return this.age;
    }

    public void setAge(AgeEnum age) {
        this.age = age;
    }

    public Integer getTestType() {
        return this.testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Long getRole() {
        return this.role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public PhoneEnum getPhone() {
        return this.phone;
    }

    public void setPhone(PhoneEnum phone) {
        this.phone = phone;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    @Override
    public String toString() {
        return "User [id=" + this.getId() + ", name=" + name + ", age=" + age
                + ", testType=" + testType + ", testDate="
                + testDate + ", role=" + role + ", phone=" + phone + "]";
    }
}
