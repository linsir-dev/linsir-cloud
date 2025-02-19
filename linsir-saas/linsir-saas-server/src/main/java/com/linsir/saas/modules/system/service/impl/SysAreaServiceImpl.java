package com.linsir.saas.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.linsir.SaaS.modules.system.vo.SysAreaVO;
import com.linsir.core.constant.SymbolConstant;
import com.linsir.core.mybatis.entity.Organization;
import com.linsir.core.mybatis.service.impl.BaseServiceImpl;
import com.linsir.SaaS.modules.system.entity.SysArea;
import com.linsir.core.mybatis.util.BeanUtils;
import com.linsir.core.mybatis.util.S;
import com.linsir.core.mybatis.util.V;
import com.linsir.core.mybatis.vo.OrganizationVO;
import com.linsir.saas.modules.system.mapper.SysAreaMapper;
import com.linsir.saas.modules.system.service.SysAreaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/25 16:42:11
 */
@Service
public class SysAreaServiceImpl extends BaseServiceImpl<SysAreaMapper, SysArea> implements SysAreaService {

    /**
     * TODO 有bug
     * @param rootSysAreaId
     * @return
     */
    @Override
    public List<SysAreaVO> getAreaTree(Long rootSysAreaId) {

        if(rootSysAreaId == null){
            return Collections.emptyList();
        }
        //获取父对象
        SysArea parentSysArea = getEntity(rootSysAreaId);
        LambdaQueryWrapper<SysArea> select = Wrappers.lambdaQuery();
        if (parentSysArea != null) {
            String parentIds;
            if (parentSysArea.getParentIdsPath()==null)
            {
                parentIds = rootSysAreaId + SymbolConstant.SEPARATOR_COMMA;
            }
            else {
                if (parentSysArea.getParentIdsPath().endsWith(SymbolConstant.SEPARATOR_COMMA))
                {
                    parentIds = parentSysArea.getParentIdsPath() + rootSysAreaId;
                }else {
                    parentIds = parentSysArea.getParentIdsPath() + SymbolConstant.SEPARATOR_COMMA + rootSysAreaId;
                }
            }
            select.likeRight(SysArea::getParentIdsPath, parentIds);
        }
        select.orderByAsc(SysArea::getId);
        List<SysArea> sysAreaList = getEntityList(select);
        List<SysAreaVO> sysAreaVOList =  BeanUtils.convertList(sysAreaList, SysAreaVO.class);
        return  BeanUtils.buildTree(sysAreaVOList, rootSysAreaId);
    }
}
