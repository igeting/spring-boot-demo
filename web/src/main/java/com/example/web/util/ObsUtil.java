package com.example.web.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ObsUtil {

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * 演示上传表单文件，文件可以从文件流中获取，也可以读取本地文件
     *
     * @param fileName
     * @param fileContent
     * @return
     */
    public String uploadFile(String fileName, byte[] fileContent) {
        try {
            MultiValueMap params = new LinkedMultiValueMap();
            ByteArrayResource file = new ByteArrayResource(fileContent) {
                @Override
                public String getFilename() {
                    return fileName;
                }

                @Override
                public long contentLength() {
                    return fileContent.length;
                }
            };
            List<ByteArrayResource> files = new ArrayList<>();
            files.add(file);
            params.put("file", files);

            String url = "http://www.example.com/upload";
            String res = restTemplate.postForObject(url, params, String.class);
            return res;
        } catch (Exception e) {
            log.error("uploadFile error:{}", e.getMessage(), e);
        }
        return null;
    }

    /**
     * 下载文件
     *
     * @param fileId
     * @return
     */
    public byte[] downloadFile(String fileId) {
        try {
            String url = "http://www.example.com/download";
            byte[] res = restTemplate.getForObject(url, byte[].class);
            return res;
        } catch (Exception e) {
            log.error("uploadFile error:{}", e.getMessage(), e);
        }
        return null;
    }
}
