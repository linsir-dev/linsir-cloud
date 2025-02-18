package com.linsir.saas.modules.system.service.impl;


import com.linsir.core.code.ResultCode;
import com.linsir.core.mybatis.exception.BusinessException;
import com.linsir.core.mybatis.service.impl.BaseServiceImpl;
import com.linsir.SaaS.modules.system.entity.SysTenantExt;
import com.linsir.SaaS.modules.system.entity.SysTenantExtWeb;
import com.linsir.saas.modules.system.mapper.SysTenantExtWebMapper;
import com.linsir.saas.modules.system.service.SysTenantExtService;
import com.linsir.saas.modules.system.service.SysTenantExtWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：linsir
 * @date ：Created in 2022/10/1 10:39
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class SysTenantExtWebServiceImpl extends BaseServiceImpl<SysTenantExtWebMapper,SysTenantExtWeb> implements SysTenantExtWebService{

    @Autowired
    private SysTenantExtService sysTenantExtService;

    /**
     *  基于租户id创建扩展
     * @return
     */
    @Override
    @Transactional(rollbackFor = BusinessException.class)
    public boolean createEntity(Long tenantId , SysTenantExtWeb sysTenantExtWeb)
    {
        boolean result = false;
        try {
            if (super.createEntity(sysTenantExtWeb))
            {
                SysTenantExt sysTenantExt = new SysTenantExt();
                sysTenantExt.setTenantId(tenantId);
                sysTenantExt.setExtId(sysTenantExtWeb.getId());
                sysTenantExt.setType("web");
                result = sysTenantExtService.createEntity(sysTenantExt);
            }
        }catch (Exception ex)
        {
            throw new BusinessException(ResultCode.FAIL_OPERATION,ex);
        }
       return result;
    }

}
