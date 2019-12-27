package com.spring.framework.common.base.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Util {

    public static String getMD5String(String context, String key) throws Exception {
        if (!TextUtil.isEmpty(key)) {
            key = "MD5";
        }
        MessageDigest messageDigest = MessageDigest.getInstance(key);
        messageDigest.update(context.getBytes("UTF-8"));
        String str = new BigInteger(1, messageDigest.digest()).toString(16);
        while (str.length() < 32)
            str = "0" + str;
        return str;
    }

}
