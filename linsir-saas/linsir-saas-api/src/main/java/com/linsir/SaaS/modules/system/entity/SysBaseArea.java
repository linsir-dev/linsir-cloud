package com.linsir.SaaS.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.linsir.core.mybatis.entity.BaseEntity;
import lombok.Data;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/29 18:03:34
 */
@Data
@TableName("sys_base_area")
public class SysBaseArea extends BaseEntity<Long> {

    private Long countryId;

    private String path;

    private String parentId;

    private String areaCode;

    private String areaName;

    /*简拼*/
    private String simpleSpelling;

    private String layer;

    private String sortCode;

    private boolean deleteMark;

    private boolean enabled;

    private String description;
}
