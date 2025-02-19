package com.linsir.SaaS.modules.system.dto;


import com.linsir.SaaS.modules.system.entity.SysMeta;
import com.linsir.SaaS.modules.system.entity.SysResource;
import lombok.Data;

/**
 * description：SysMetaAddDTO
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/20 4:54
 */
@Data
public class SysMetaAddDTO {

    private SysMeta sysMeta;

    private SysResource sysResource;
}
