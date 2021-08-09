package com.example.common.util.jvm;

import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserClassLoader extends ClassLoader{
    public static void main(String[] args) throws ClassNotFoundException {
        UserClassLoader userClassLoader = new UserClassLoader();
        Class<?> clazz = Class.forName("com.example.common.util.jvm.Test", true, userClassLoader);
        ClassLoader classLoader = null;
        try {
            Object o = clazz.newInstance();
            classLoader = o.getClass().getClassLoader();
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method method : declaredMethods){
                if ("say".equals(method.getName())) {
                    method.invoke(o);
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(classLoader);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            FileCopyUtils.copy(new FileInputStream(new File("/Users/c/Desktop/Test.class")), bos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = bos.toByteArray();
        return defineClass(name, bytes, 0, bytes.length);
    }
}
