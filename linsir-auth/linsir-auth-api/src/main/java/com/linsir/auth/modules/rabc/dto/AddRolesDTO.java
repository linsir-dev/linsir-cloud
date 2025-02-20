package com.linsir.auth.modules.rabc.dto;


import lombok.Data;

import java.util.List;

/**
 * description：AddRolesDTO
 * author     ：linsir
 * version    ： v1.2.0
 * date       ：2025/2/21 6:32
 */
@Data
public class AddRolesDTO {

    private Long userId;

    private List<Long> roleIds;
}
