package cn.edu.nju.notebook.util;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created on 2019/1/14
 */
public class MD5Encryption {

    public static String encrypt(String word) throws NoSuchAlgorithmException {
        //用于加密密码
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] input = word.getBytes();
        byte[] output = md.digest(input);
        return Base64.encodeBase64String(output);
    }

}
