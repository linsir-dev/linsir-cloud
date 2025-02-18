package com.linsir.SaaS.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.linsir.core.mybatis.entity.BaseEntity;
import lombok.Data;

/**
 * description:系统应用
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/26 17:38:32
 */
@Data
@TableName("sys_application")
public class SysApplication extends BaseEntity<Long> {

    private String name;

    private String englishName;

    private String ver;

    private String business;

    private String ico;

    private String intoLink;

    private String loginImg;

    private String logo;
}
