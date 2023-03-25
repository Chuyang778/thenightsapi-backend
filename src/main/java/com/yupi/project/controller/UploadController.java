package com.yupi.project.controller;

import com.yupi.project.common.BaseResponse;
import com.yupi.project.common.ResultUtils;
import com.yupi.project.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author ChuYang
 * @version 1.0
 */
@RestController
@Slf4j
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public BaseResponse<String> upload(MultipartFile file) throws IOException{
        log.info("文件上传，文件名{}",file.getOriginalFilename());
        String url = aliOSSUtils.upload(file);
        log.info("上传完成，地址为{}",url);
        return ResultUtils.success(url);
    }
}
