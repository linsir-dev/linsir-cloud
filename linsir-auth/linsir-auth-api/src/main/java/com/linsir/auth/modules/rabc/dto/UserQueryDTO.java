package com.linsir.auth.modules.rabc.dto;


import com.linsir.auth.modules.rabc.entity.UserExtMeta;
import com.linsir.core.mybatis.binding.query.BindQuery;
import com.linsir.core.mybatis.binding.query.Comparison;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author linsir
 * @version 1.0.0
 * @title AccountQueryDTO
 * @description
 * @create 2024/8/9 22:27
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryDTO extends PageQuery{

    //这里做联合查询
    @BindQuery(comparison = Comparison.LIKE,entity = UserExtMeta.class,field = "nickname",condition = "this.id = user_ext.user.id And user_ext.ext.id = user_ext_meta.id")
    private String keywords;

    private String status;

    private String deptId;

    private String createTimeRange;
}
