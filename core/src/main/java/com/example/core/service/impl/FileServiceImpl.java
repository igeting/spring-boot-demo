package com.example.core.service.impl;

import com.example.core.entity.base.CommonResult;
import com.example.core.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@Slf4j
@Component
@PropertySource(value = {"classpath:version.yml"})
public class FileServiceImpl implements FileService {
    @Value("${file.upload.path}")
    private String uploadPath;

    @Value("${version}")
    private String version;

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @Override
    public CommonResult uploadFile(MultipartFile file) throws Exception {
        CommonResult result = new CommonResult();
        String name = file.getOriginalFilename();
        log.info("upload file name:{}", name);
        long size = file.getSize();
        log.info("upload file size:{}", size);
        try {
            File dir = new File(uploadPath, version);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File fo = new File(dir, name);
            InputStream fi = file.getInputStream();
            FileCopyUtils.copy(fi, new FileOutputStream(fo));
            result.setCode(200);
            result.setMessage("success");
            result.setData(fo.getPath());
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
}