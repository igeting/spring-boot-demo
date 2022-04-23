package com.example.core.utils;

import ch.qos.logback.core.PropertyDefinerBase;

import java.net.InetAddress;

public class HostnameProperty extends PropertyDefinerBase {
    @Override
    public String getPropertyValue() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "127.0.0.1";
    }
}
