package com.linsir.saas.modules.system.service.impl;


import com.linsir.core.mybatis.service.impl.BaseServiceImpl;
import com.linsir.SaaS.modules.system.entity.SysApplication;
import com.linsir.saas.modules.system.mapper.SysApplicationMapper;
import com.linsir.saas.modules.system.service.SysApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/26 18:27:34
 */
@Service
public class SysApplicationServiceImpl extends BaseServiceImpl<SysApplicationMapper, SysApplication> implements SysApplicationService {
    @Override
    public List<SysApplication> convertFilterData(List<SysApplication> applicationList) {
        return List.of();
    }

   /* @Override
    public FilterDataVO convertFilterData(List<SysApplication> applicationList) {
        FilterDataVO filterDataVO = new FilterDataVO();
        filterDataVO.setTitle("应用分类");
        filterDataVO.setKey("type");
        filterDataVO.setMultiple(true);
        List<Option> optionList = new ArrayList<>();

        applicationList.stream().forEach(sysApplication -> {
            Option option = new Option();
            option.setLabel(sysApplication.getName());
            option.setValue(sysApplication.getId().toString());
            optionList.add(option);
        });
        filterDataVO.setOptions(optionList);

        return filterDataVO;
    }*/
}
