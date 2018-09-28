package com.example.model.entity;

/**
 * @Author: Louis
 * @Date: 9/21/2018
 * @Description:
 */

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.mybatis.plus.actable.annotation.Column;
//import com.mybatis.plus.actable.annotation.Column;

import java.io.Serializable;

/**
 * 演示实体父类
 */
public class SuperEntity<T extends Model> extends Model<T> {

    /**
     * 主键ID , 这里故意演示注解可以无
     */
    @TableId("test_id")
    @Column(name ="test_id", isKey = true,type = "varchar", length = 80)
    private String id;

    @TableField(exist = false)
    private Long tenantId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public SuperEntity setTenantId(Long tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
