package com.spring.framework.common.base.rules;

import com.spring.framework.common.util.MD5Util;
import com.spring.framework.common.util.TextUtil;

import java.util.Random;

public class PrimaryKeyRule
{
    public static String nextId(String keyId, String keyNumber, String flagNumber)
    {
        Random random = new Random();
        String newid = keyId
                + TextUtil.expandNum(Integer.valueOf(keyNumber), "0", 6)
                + TextUtil.expandNum(Integer.valueOf(flagNumber), "0", 6)
                + TextUtil.expandNum(random.nextInt(999999), "0", 6)
                + System.currentTimeMillis();
        return newid;
    }

    public static String primaryPassword(String password) throws Exception
    {
        String newPassword = MD5Util.getMD5String(password);
        return newPassword;
    }
}
