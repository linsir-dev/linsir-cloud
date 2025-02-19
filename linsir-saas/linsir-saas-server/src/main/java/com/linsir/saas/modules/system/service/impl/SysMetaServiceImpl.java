package com.linsir.saas.modules.system.service.impl;

import com.linsir.SaaS.modules.system.entity.SysResource;
import com.linsir.core.mybatis.exception.BusinessException;
import com.linsir.core.mybatis.service.impl.BaseServiceImpl;
import com.linsir.SaaS.modules.system.entity.SysMeta;
import com.linsir.core.mybatis.util.ISetter;
import com.linsir.saas.modules.system.mapper.SysMetaMapper;
import com.linsir.saas.modules.system.service.SysMetaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/31 16:24:47
 */
@Service
public class SysMetaServiceImpl extends BaseServiceImpl<SysMetaMapper, SysMeta> implements SysMetaService {

    @Transactional(rollbackFor = Exception.class)
    public boolean createEntityAndRelatedEntity(SysMeta sysMeta, SysResource sysResource) {
        boolean success = false;
        try {
            success = createEntity(sysMeta);
            if (success) {
                success  = createRelatedEntity(sysMeta.getId(),sysResource,SysResource::setMetaId);
            }
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        return success;
    }

}
