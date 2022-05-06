package com.example.core.controller.test;

import com.example.core.model.base.BaseResult;
import com.example.core.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping(value = "/api/file")
public class FileController {
    @Autowired
    private FileService fileService;

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @PostMapping(value = "/uploadFile")
    public BaseResult uploadFile(@RequestParam MultipartFile file) {
        try {
            return fileService.uploadFile(file);
        } catch (Exception e) {
            log.error("FileController uploadFile error", e);
        }
        return new BaseResult();
    }
}
