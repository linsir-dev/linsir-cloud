package com.linsir.saas.modules.system.controller;


import com.linsir.core.mybatis.controller.BaseCrudRestController;
import com.linsir.core.mybatis.vo.JsonResult;
import com.linsir.core.results.R;
import com.linsir.SaaS.modules.system.entity.SysTenant;
import com.linsir.saas.modules.system.service.SysTenantExtWebService;
import com.linsir.saas.modules.system.service.SysTenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * description:
 * *******************************************************
 * <p>
 * v2 版本  *
 * ******************************************************
 *
 * @author: linsir
 * @version: 1.2.0  *
 * @date: 2023/4/13 21:20
 */

@RestController
@RequestMapping("/v2/sysTenant/")
public class SysTenantV2Controller extends BaseCrudRestController<SysTenant> {

    @Autowired
    private SysTenantService sysTenantService;

    @Autowired
    private SysTenantExtWebService sysTenantExtWebService;



    /**
     * 租户列表信息
     * @param sysTenantDto
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */
   /* @RequestMapping(value = "list",method = {RequestMethod.GET})
    public R list(SysTenantDto sysTenantDto, @RequestParam(value = "page") int page, @RequestParam(value = "pageSize") int pageSize) throws Exception {
        R result = null;
        QueryWrapper queryWrapper = buildQueryWrapperByDTO(sysTenantDto);
        Pagination pagination = new Pagination(SysTenantVO.class);
        pagination.setPageIndex(page);
        pagination.setPageSize(pageSize);
        result = exec("租户信息列表查询",()->{
            List<SysTenantVO> sysTenantList = sysTenantService.getViewObjectList(queryWrapper,pagination,SysTenantVO.class);
            PageVO<SysTenantVO, Summary> pageVO = new PageVO<>(pagination,sysTenantList);
            return Result.SUCCESS(pageVO);
        });
        return result;
    }*/


   /* @PostMapping("add")
    public R add(@RequestBody SysTenant sysTenant)  {
        R result = null;
        try {
           result = exec("添加租户信息",() ->{
                boolean res = sysTenantService.createEntity(sysTenant);
                return Result.SUCCESS(res);
            });
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return result;
    }*/



    

    /*@GetMapping("get/{id}")
    public R get(@PathVariable("id") Long id) throws Exception {
        R result = null;
        result = exec("获取用户",()->{
            SysTenantVO sysTenantVO = sysTenantService.getViewObject(id, SysTenantVO.class);
            return Result.SUCCESS(sysTenantVO);
        });
        return result;
    }*/

    /**
     *  通过id
     * @param id
     * @return
     */
    @GetMapping("get/{id}")
    public R get(@PathVariable("id") Long id){
        return exec(1,()->{
            return JsonResult.OK(getEntity(id));
        });
    }



    /**
     * 获取租户编码
     * @return
     * @throws Exception
     */
    /*@GetMapping("generateCode")
    public R generateCode() throws Exception {
        R result = null;
        result = exec("获取租户编码",()->{
            String tenantCode = sysTenantService.generateCode();
           return Result.SUCCESS(tenantCode);
        });
        return result;
    }*/


    /**
     * 按照域名进行查找租户web信息
     * @param domain
     * @return
     */
   /* @GetMapping("getByDomain")
    public R getByDomain(String domain) throws Exception {
        R r = null;
        r = exec("按照域名进行查找租户web信息",()->{
            QueryWrapper<SysTenantExtWeb> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("domain_name",domain);
            SysTenantExtWeb sysTenantExtWeb = sysTenantExtWebService.getSingleEntity(queryWrapper);
            return Result.SUCCESS(sysTenantExtWeb);
        });
        return  r;
    }*/

}
