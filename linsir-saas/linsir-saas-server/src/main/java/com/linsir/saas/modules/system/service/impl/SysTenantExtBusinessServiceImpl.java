package com.linsir.saas.modules.system.service.impl;

import com.linsir.SaaS.modules.system.entity.SysTenantExt;
import com.linsir.SaaS.modules.system.entity.SysTenantExtWeb;
import com.linsir.core.code.ResultCode;
import com.linsir.core.mybatis.exception.BusinessException;
import com.linsir.core.mybatis.service.impl.BaseServiceImpl;
import com.linsir.SaaS.modules.system.entity.SysTenantExtBusiness;
import com.linsir.saas.modules.system.mapper.SysTenantExtBusinessMapper;
import com.linsir.saas.modules.system.service.SysTenantExtBusinessService;
import com.linsir.saas.modules.system.service.SysTenantExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：linsir
 * @date ：Created in 2022/10/1 10:47
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class SysTenantExtBusinessServiceImpl extends BaseServiceImpl<SysTenantExtBusinessMapper, SysTenantExtBusiness> implements SysTenantExtBusinessService {

    @Autowired
    private SysTenantExtService sysTenantExtService;


    @Transactional
    @Override
    public boolean createEntity(Long tenantId, SysTenantExtBusiness sysTenantExtBusiness) {
        boolean result = false;
        try {
            if (super.createEntity(sysTenantExtBusiness))
            {
                SysTenantExt sysTenantExt = new SysTenantExt();
                sysTenantExt.setTenantId(tenantId);
                sysTenantExt.setExtId(sysTenantExtBusiness.getId());
                sysTenantExt.setType("business");
                result = sysTenantExtService.createEntity(sysTenantExt);
            }
        }catch (Exception ex)
        {
            throw new BusinessException(ResultCode.FAIL_OPERATION,ex);
        }
        return result;
    }
}
