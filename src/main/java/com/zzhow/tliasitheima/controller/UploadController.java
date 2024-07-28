package com.zzhow.tliasitheima.controller;

import com.zzhow.tliasitheima.pojo.Result;
import com.zzhow.tliasitheima.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ZZHow
 * @date 2024/7/26
 */
@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @PostMapping
    public Result upload(MultipartFile image) {
        log.info("文件上传：image:{}", image);

        String fileName = uploadService.upload(image);

        return Result.success(fileName);
    }
}
