package com.zzhow.tliasitheima.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author ZZHow
 * @date 2024/7/26
 */
public interface UploadService {
    /**
     * 上传文件
     *
     * @param file-源文件
     * @return String-文件全路径
     */
    String upload(MultipartFile file);
}
