package com.zhou;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 强 on 2018/9/28.
 */
public class SimpleMD5Example {
    public static void main(String[] args) {
        String password  = "ljy0326.";
        String generatePassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatePassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(generatePassword);
    }
}
