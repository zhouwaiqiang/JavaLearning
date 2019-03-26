package com.zhou;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 强 on 2018/9/28.
 */
public class BcryptHashingExample {
    public static void main(String[] args) throws NoSuchAlgorithmException
    {
        String  originalPassword = "ljy0326.";

        System.out.println(originalPassword.substring(1, originalPassword.length()));
        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
        System.out.println(generatedSecuredPasswordHash);

        boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
        System.out.println(matched);

    }
}
