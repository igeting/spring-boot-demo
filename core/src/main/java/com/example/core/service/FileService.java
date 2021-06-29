package com.example.core.service;

import com.example.core.entity.base.CommonResult;
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
