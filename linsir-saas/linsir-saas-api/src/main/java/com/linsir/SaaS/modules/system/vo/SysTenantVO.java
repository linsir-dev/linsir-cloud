package com.linsir.SaaS.modules.system.vo;

import com.linsir.core.mybatis.binding.annotation.BindEntity;
import com.linsir.core.mybatis.binding.annotation.BindFieldList;
import com.linsir.SaaS.modules.system.entity.SysTenant;
import com.linsir.SaaS.modules.system.entity.SysTenantExt;
import com.linsir.SaaS.modules.system.entity.SysTenantExtBusiness;
import com.linsir.SaaS.modules.system.entity.SysTenantExtWeb;
import lombok.Data;

import java.util.List;

/**
 * @ProjectName: linsir
 * @Package: com.linsir.saas.modules.system.vo
 * @ClassName: SysTenantVO
 * @Description: 租户对象vo
 * @Author:Linsir
 * @CreateDate: 2022/9/26 15:36
 * @UpdateDate: 2022/9/26 15:36
 * @Version: 0.0.1
 */

@Data
public class SysTenantVO extends SysTenant {

    @BindEntity(entity = SysTenantExtWeb.class,condition = "this.id = sys_tenant_ext.tenant_id AND sys_tenant_ext.ext_id = id AND sys_tenant_ext.type = 'web'")
    private SysTenantExtWeb sysTenantExtWeb;

    @BindEntity(entity = SysTenantExtBusiness.class,condition = "this.id = sys_tenant_ext.tenant_id AND sys_tenant_ext.ext_id = id AND sys_tenant_ext.type = 'business'")
    private SysTenantExtBusiness sysTenantExtBusiness;

    @BindFieldList(entity = SysTenantExt.class,field = "type",condition = "this.id = sys_tenant_ext.tenant_id")
    private List<String> types;
}
