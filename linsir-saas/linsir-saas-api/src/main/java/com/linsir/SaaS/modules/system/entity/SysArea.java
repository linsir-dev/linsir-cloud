package com.linsir.SaaS.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.linsir.core.mybatis.entity.BaseEntity;
import com.linsir.core.mybatis.entity.BaseTreeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description: 系统区域规划
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/25 12:39:27
 */

@EqualsAndHashCode(callSuper = true)
@TableName("sys_area")
@Data
public class SysArea extends BaseTreeEntity<Long> {

    private String label;

    private String code;

    private String type;

}
