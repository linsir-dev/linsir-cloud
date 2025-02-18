package com.linsir.saas.modules.system.service;

import com.linsir.core.mybatis.service.BaseService;
import com.linsir.SaaS.modules.system.entity.SysBaseCountry;

import java.util.List;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/29 18:44:47
 */

public interface SysBaseCountryService extends BaseService<SysBaseCountry> {

   List<SysBaseCountry> continentList(List<SysBaseCountry> sysBaseCountryList);
}
