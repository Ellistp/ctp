package com.ctp.ghub.utils;

import java.security.SecureRandom;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

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

    /**
     * 产生一个36个字符的UUID
     *
     * @return UUID
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * md5加密
     *
     * @param value 要加密的值
     * @return md5加密后的值
     */
    public static String md5Hex(String value) {
        return DigestUtils.md5Hex(value);
    }

    /**
     * sha1加密
     *
     * @param value 要加密的值
     * @return sha1加密后的值
     */
    public static String sha1Hex(String value) {
        return DigestUtils.sha1Hex(value);
    }

    /**
     * sha256加密
     *
     * @param value 要加密的值
     * @return sha256加密后的值
     */
    public static String sha256Hex(String value) {
        return DigestUtils.sha256Hex(value);
    }
}
