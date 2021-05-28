package com.example.demo.service;

import com.example.demo.bean.CommonResult;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    CommonResult uploadFile(MultipartFile file) throws Exception;
}
