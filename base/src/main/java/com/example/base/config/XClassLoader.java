package com.example.base.config;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class XClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = "/" + name.replaceAll("\\.", "/") + ".class";
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        byte[] b = new byte[1024];
        int len = 0;
        try {
            is = this.getClass().getResourceAsStream(path);
            bos = new ByteArrayOutputStream();
            while ((len = is.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            byte[] data = bos.toByteArray();
            Class<?> claazz = defineClass(name, data, 0, data.length);
            return claazz;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
