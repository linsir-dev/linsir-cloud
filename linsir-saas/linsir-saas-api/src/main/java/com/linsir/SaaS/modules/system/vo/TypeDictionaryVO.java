package com.linsir.SaaS.modules.system.vo;

import com.linsir.core.mybatis.entity.Dictionary;
import lombok.Data;

import java.util.List;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/30 13:16:53
 */
@Data
public class TypeDictionaryVO extends Dictionary {

    private String label;

    private List<TypeDictionaryVO> children;
}
