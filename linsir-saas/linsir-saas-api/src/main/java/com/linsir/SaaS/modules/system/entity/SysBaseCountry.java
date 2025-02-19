package com.linsir.SaaS.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.linsir.core.mybatis.entity.BaseEntity;
import lombok.Data;

/**
 * description: 国家基础信息
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/29 17:22:01
 */

@TableName("sys_base_country")
@Data
public class SysBaseCountry extends BaseEntity<Long> {

    /*二位国家编码*/
   private String twoBitCode;

   /*三位国家编码*/
   private String threeBitCode;

   private String name;

   private int continent;

   private boolean enabled;

   private String description;
}
