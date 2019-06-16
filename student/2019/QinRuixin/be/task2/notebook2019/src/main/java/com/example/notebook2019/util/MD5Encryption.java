package com.example.notebook2019.util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Encryption {
    public static String encrype(String word) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] input = word.getBytes();
        byte[] output = messageDigest.digest(input);
        return Base64.encodeBase64String(output);
    }
}
