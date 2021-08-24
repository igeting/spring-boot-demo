package com.example.web.util.web;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class ObsUtil {

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
            String s = new RestTemplate().postForObject(url, params, String.class);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] downloadFile(String fileId) {
        try {
            String url = "http://www.example.com/download";
            byte[] res = new RestTemplate().getForObject(url, byte[].class);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
