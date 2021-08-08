package com.example.common.util;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class RSAUtil {
    public static String privateKey;
    public static String publicKey;

    public static Map<String, String> genKeyPair() throws NoSuchAlgorithmException {
        Map<String, String> pair = new HashMap<>();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024, new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        String privateKeyString = new String(Base64.getEncoder().encode(privateKey.getEncoded()));
        String publicKeyString = new String(Base64.getEncoder().encode(publicKey.getEncoded()));
        RSAUtil.privateKey = privateKeyString;
        RSAUtil.publicKey = publicKeyString;
        pair.put("private", privateKeyString);
        pair.put("public", publicKeyString);
        return pair;
    }

    public static String encrypt(String str, String publicKey) throws Exception {
        byte[] decoded = Base64.getDecoder().decode(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    public static String decrypt(String str, String privateKey) throws Exception {
        byte[] inputByte = Base64.getDecoder().decode(str.getBytes("UTF-8"));
        byte[] decoded = Base64.getDecoder().decode(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

    public static void main(String[] args) {
        try {
            genKeyPair();
            System.out.println(RSAUtil.privateKey);
            System.out.println(RSAUtil.publicKey);
            String str = "hello world";
            String enc = encrypt(str, RSAUtil.publicKey);
            System.out.println(enc);
            String dec = decrypt(enc, RSAUtil.privateKey);
            System.out.println(dec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


















