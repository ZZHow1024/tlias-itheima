package com.zzhow.tliasitheima.dao.impl;

import com.zzhow.tliasitheima.dao.LocalFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author ZZHow
 * @date 2024/7/26
 */
@Slf4j
@Repository
public class localFileImpl implements LocalFile {
    @Override
    public void saveToLocal(String fileName, MultipartFile file) {
        Path directoriesPath = Paths.get(fileName).getParent();
        try {
            Files.createDirectories(directoriesPath);
        } catch (IOException e) {
            log.info("Create folder, IOException: {}", e.getMessage());
        }

        try {
            file.transferTo(new File(fileName));
            log.info("文件路径：{}", fileName);
        } catch (IOException e) {
            log.info("Save File, IOException: {}", e.getMessage());
        }
    }
}
