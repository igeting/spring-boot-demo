package com.example.demo.utils;

import ch.qos.logback.core.PropertyDefinerBase;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostnameProperty extends PropertyDefinerBase {
    @Override
    public String getPropertyValue() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "localhost";
    }
}
