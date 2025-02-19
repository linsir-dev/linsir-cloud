package com.linsir.SaaS.modules.system.vo;

import com.linsir.SaaS.modules.system.entity.SysArea;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/26 11:36:32
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysAreaVO extends SysArea {

    List<SysAreaVO>  children;
}
