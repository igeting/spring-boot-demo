package com.example.demo.controller;

import com.example.demo.bean.CommonResult;
import com.example.demo.service.FileService;
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
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @PostMapping(value = "/uploadFile")
    public CommonResult uploadFile(@RequestParam MultipartFile file) {
        try {
            return fileService.uploadFile(file);
        } catch (Exception e) {
            log.error("FileController uploadFile error", e);
        }
        return new CommonResult();
    }
}
