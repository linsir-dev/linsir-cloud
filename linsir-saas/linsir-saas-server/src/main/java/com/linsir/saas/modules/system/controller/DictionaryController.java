package com.linsir.saas.modules.system.controller;

import com.linsir.SaaS.modules.system.entity.SysTenant;
import com.linsir.core.constant.TypeConstant;
import com.linsir.core.mybatis.controller.BaseCrudRestController;
import com.linsir.core.mybatis.entity.Dictionary;
import com.linsir.core.mybatis.service.impl.DictionaryServiceExtImpl;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.results.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * description:
 *
 * @author [linsir]
 * @version 0.0.1
 * @date 2022/08/29 19:15:21
 */
@RestController
@RequestMapping("/dictionary/")
public class DictionaryController extends BaseCrudRestController<Dictionary> {

    @Autowired
    private DictionaryServiceExtImpl dictionaryServiceExt;


    /**
     * 这里需要调用
     * @param dictionary
     * @return
     */
    @PostMapping("add")
    public R add(Dictionary dictionary) {
        return exec(TypeConstant.LOG_TYPE_4,()->{
            return JsonResult.OK(dictionaryServiceExt.createEntity(dictionary));
        });
    }

    @DeleteMapping("del/{id}")
    public R del(@PathVariable("id") Long id)  {
        return exec(TypeConstant.LOG_TYPE_6,()->{
            return deleteEntity(id);
        });
    }


    @PostMapping("update")
    public R update(@RequestBody Dictionary dictionary) {
        return exec(TypeConstant.LOG_TYPE_5,()->{
            return updateEntity(dictionary.getId(),dictionary);
        });
    }

  /**
   * @description: get
   * @date: 2025/2/19 18:12
   * @Auther: linsir
   */
    @GetMapping("get/{id}")
    public R get(@PathVariable("id") Long id )
    {
        return exec(TypeConstant.LOG_TYPE_3,()->{
            return JsonResult.OK(getEntity(id));
        });
    }


    /**
     * 通过类型获取 字典
     * @description: getEntityListByType
     * @date: 2025/2/19 18:25
     * @Auther: linsir
     */
    @GetMapping("getLabelValueList")
    public R getLabelValueList(String type)
    {
        return exec(TypeConstant.LOG_TYPE_3,()->{
           return JsonResult.OK(dictionaryServiceExt.getLabelValueList(type));
        });
    }


}
