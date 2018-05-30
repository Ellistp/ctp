package com.ctp.ghub.utils;

import java.security.SecureRandom;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/30
 */
public class RandomCodeGeneratorUtil {

    /**
     * 获取 随机的数字字母组合 10位
     * @return
     */
    public static String getRandomArabicNumber() {
        return new RandomStringUtil(10, new SecureRandom(), RandomStringUtil.ARABIC_NUMBER + RandomStringUtil.UPPER_CAPITAL).nextRandomString();
    }

    /**
     * 获取 随机的注册验证码 6位
     * @return
     */
    public static String getRandomRegisterVerifyCode() {
        return  new RandomStringUtil(6, new SecureRandom(), RandomStringUtil.ARABIC_NUMBER).nextRandomString();
    }
}
