package com.zzhow.tliasitheima.dao;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author ZZHow
 * @date 2024/7/26
 */
public interface LocalFile {
    /**
     * 保存文件到本地
     * @param fileName-全文件名
     * @param file-源文件
     */
    void saveToLocal(String fileName, MultipartFile file);
}
