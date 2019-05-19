package com.ckkj.exchangeoflearningplatform.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5
 *
 * @author lzh
 * create 2019-05-10-10:37
 */
public class MD5Utils {

    /**
     * 使用md5的算法进行加密
     *
     * @param plainTest
     * @return
     */
    public static String md5(String plainTest) {
        byte[] secretBytes = null;

        try {
            secretBytes = MessageDigest.getInstance("md5").digest(plainTest.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }

        return md5code;
    }
}
