package com.linsir.saas.modules.system.service;

import com.linsir.core.mybatis.service.BaseService;
import com.linsir.SaaS.modules.system.entity.SysTenantExtWeb;

/**
 * @author ：linsir
 * @date ：Created in 2022/10/1 10:38
 * @description：
 * @modified By：
 * @version:
 */
public interface SysTenantExtWebService extends BaseService<SysTenantExtWeb> {

    boolean editExtWeb(Long sysTenantId,SysTenantExtWeb sysTenantExtWeb);
}
