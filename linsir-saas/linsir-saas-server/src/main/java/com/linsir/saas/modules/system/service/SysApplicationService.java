package com.linsir.saas.modules.system.service;

import com.linsir.core.mybatis.service.BaseService;
import com.linsir.saas.modules.system.entity.SysApplication;

import java.util.List;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/26 18:26:43
 */
public interface SysApplicationService extends BaseService<SysApplication> {

    List<SysApplication> convertFilterData(List<SysApplication> applicationList);
}
