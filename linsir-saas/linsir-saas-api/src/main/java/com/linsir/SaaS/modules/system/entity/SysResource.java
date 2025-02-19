package com.linsir.SaaS.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.linsir.core.mybatis.entity.BaseEntity;
import com.linsir.core.mybatis.entity.BaseTreeEntity;
import lombok.Data;

/**
 * description: 系统资源，一切开发的功能点，作为资源
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/26 17:37:17
 */

@Data
@TableName("sys_resource")
public class SysResource extends BaseTreeEntity<Long> {

    private String name;

    private String path;

    private String redirect;

    private Long appId;

    private Long projectId;

    private Long metaId;

    private String type;

    private String component;

    private int sort;

    private String perm;

}
