package com.example.core.service;

import com.example.core.entity.base.BaseResult;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    BaseResult uploadFile(MultipartFile file) throws Exception;
}
