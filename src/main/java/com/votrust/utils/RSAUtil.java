package com.votrust.utils;


import java.security.*;
import java.util.Base64;
public class RSAUtil {

    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        return generator.generateKeyPair();
    }

    public static String encodeKey(Key key) {
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public static byte[] decodeKey(String base64) {
        return Base64.getDecoder().decode(base64);
    }
}
