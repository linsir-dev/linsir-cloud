package com.linsir.saas.modules.system.service;

import com.linsir.SaaS.modules.system.vo.SysAreaVO;
import com.linsir.core.mybatis.service.BaseService;
import com.linsir.SaaS.modules.system.entity.SysArea;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/25 16:41:11
 */
@Service
public interface SysAreaService  extends BaseService<SysArea> {

    List<SysAreaVO> getAreaTree(Long parentId);

}
