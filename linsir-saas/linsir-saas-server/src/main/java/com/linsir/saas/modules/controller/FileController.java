package com.linsir.saas.modules.controller;


import cn.hutool.core.net.multipart.UploadFile;
import com.linsir.core.mybatis.controller.BaseCrudRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ProjectName: linsir
 * @Package: com.linsir.saas.modules.file
 * @ClassName: FileController
 * @Description: 文件上传公共控制类
 * @Author:Linsir
 * @CreateDate: 2022/9/19 15:14
 * @UpdateDate: 2022/9/19 15:14
 * @Version:
 */
@RestController
@RequestMapping("/v1/file/")
public class FileController /*extends BaseCrudRestController<UploadFile>*/ {

    /*@Autowired
    private UploadFileService uploadFileService;*/
    /**
     * @Author linsir
     * @Description 上传文件
     * @Date 15:19 2022/9/19
     * @Param [multipartFile]
     * @return com.linsir.core.vo.IResult
     **/
    /*@PostMapping("upload")
    public ResResult upload(MultipartFile file) throws Exception {
        R result = null;
        result =exec("上传文件...",()->{
           UploadFileResult uploadFileResult = uploadFileService.upload(file);
           return Result.SUCCESS(uploadFileResult);
        });
        return new ResResult<>(result);
    }*/


}
