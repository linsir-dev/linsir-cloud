package com.linsir.SaaS.modules.dto.system;

import com.linsir.SaaS.modules.system.entity.SysTenant;
import com.linsir.core.mybatis.binding.query.BindQuery;
import com.linsir.core.mybatis.binding.query.Comparison;
import com.linsir.core.mybatis.dto.QueryListDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/25 11:55:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysTenantDTO extends SysTenant {

}
