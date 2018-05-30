package com.ctp.ghub.utils;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/30
 */
public class RandomStringUtil {

    public static final String UPPER_CAPITAL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String LOWER_CAPITAL = UPPER_CAPITAL.toLowerCase(Locale.ROOT);

    public static final String ARABIC_NUMBER = "0123456789";

    public static final String CAPITAL_NUMBER = UPPER_CAPITAL + LOWER_CAPITAL + ARABIC_NUMBER;

    private final Random random;

    private final char[] symbols;

    private final char[] buf;

    public String nextRandomString() {
        for (int idx = 0; idx < buf.length; ++idx){
            buf[idx] = symbols[random.nextInt(symbols.length)];
        }
        return new String(buf);
    }

    public RandomStringUtil(int length, Random random, String symbols) {
        if (length < 1) {
            throw new IllegalArgumentException();
        }
        if (symbols.length() < 2) {
            throw new IllegalArgumentException();
        }
        this.random = Objects.requireNonNull(random);
        this.symbols = symbols.toCharArray();
        this.buf = new char[length];
    }
    
    public RandomStringUtil(int length, Random random) {
        this(length, random, CAPITAL_NUMBER);
    }
    
    public RandomStringUtil(int length) {
        this(length, new SecureRandom());
    }
}
