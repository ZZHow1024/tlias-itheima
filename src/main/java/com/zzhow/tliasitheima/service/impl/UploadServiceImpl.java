package com.zzhow.tliasitheima.service.impl;

import com.zzhow.tliasitheima.dao.LocalFile;
import com.zzhow.tliasitheima.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

/**
 * @author ZZHow
 * @date 2024/7/26
 */
@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private LocalFile localFile;

    @Override
    public String upload(MultipartFile file) {
        File current = new File("");

        String uuid = UUID.randomUUID().toString();
        String fileExtension = Objects.requireNonNull(file.getOriginalFilename())
                .substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = current.getAbsolutePath() + "/upload/" + uuid + fileExtension;

        localFile.saveToLocal(fileName, file);

        return fileName;
    }
}
