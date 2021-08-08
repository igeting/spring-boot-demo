package com.example.common.util;

import org.junit.jupiter.api.Test;

public class RSAUtilTest {

    @Test
    public void TestRsa() {
        try {
            RSAUtil.genKeyPair();
            System.out.println(RSAUtil.privateKey);
            System.out.println(RSAUtil.publicKey);
            String str = "hello world";
            String enc = RSAUtil.encrypt(str, RSAUtil.publicKey);
            System.out.println(enc);
            String dec = RSAUtil.decrypt(enc, RSAUtil.privateKey);
            System.out.println(dec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}