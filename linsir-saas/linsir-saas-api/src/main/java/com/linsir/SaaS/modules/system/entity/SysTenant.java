package com.linsir.SaaS.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.linsir.core.mybatis.binding.query.BindQuery;
import com.linsir.core.mybatis.binding.query.Comparison;
import com.linsir.core.mybatis.data.annotation.DataMask;
import com.linsir.core.mybatis.entity.BaseEntity;
import lombok.Data;

/**
 * @author linsir
 * @title: Tenant
 * @projectName lins
 * @description: 租户基本信息
 *
 * @date 2021/12/11 17:10
 */
@Data
@TableName("sys_tenant")
public class SysTenant extends BaseEntity<Long> {

    /*租户编码*/
    private String tenantCode;

    /*租户名称*/
    @BindQuery(comparison = Comparison.LIKE)
    private String name;


    /*联系方式*/
    @DataMask
    private String tel;

    /*电话*/
    @DataMask
    private String phone;

    /*传真*/
    private String fax;


    /*简要地址*/
    private String address;

    /*是否可用,1：可用 0：不可用*/
    private boolean enable;

    /*到期时间，可以为永久*/
    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    private String timeExpiration;

    /*描述*/
    private String description;
}
