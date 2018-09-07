package com.ctp.ghub.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;

/**
 * @author chengtianping
 * @description
 * @date 2018/9/7
 */
public class XssFilterUtils {

    private static final String REGEX_IMG = "(<img.*src\\s*=\\s*(.*?)[^>]*?>)";

    private static final String REGEX_IMG_SRC = "src\\s*=\\s*\"?(.*?)(\"|>|\\s+)";

    // 过滤所有以<开头以>结尾的标签
    private final static String REGEX_HTML = "<([^>]*)>";

    private static final Pattern P_IMAGE = compile(REGEX_IMG, CASE_INSENSITIVE);

    private static final Pattern REPLSE_IMG = compile(REGEX_IMG, CASE_INSENSITIVE);

    private static final Pattern REPLSE_HTML = compile(REGEX_HTML, CASE_INSENSITIVE);

    /**
     * 去除图片和HTML标签
     * @param content
     * @return
     */
    public static String replseHtml(String content){
        try {
            if(StringUtils.isBlank(content)){
                return "";
            }
            return Jsoup.clean(content, Whitelist.basicWithImages());
        }catch (Exception e){
            //LOGGER.error(e.getMessage());
            return content;
        }
    }

    /**
     * 去除所有的图片 标签
     * @return
     */
    public static String replseAllImg(String content){
        try {
            Matcher matcherImg = REPLSE_IMG.matcher(content);
            content = matcherImg.replaceAll("");

            Matcher matcherHtml = REPLSE_HTML.matcher(content);
            content = matcherHtml.replaceAll("");
        }catch (Exception e){
            //LOGGER.error(e.getMessage());
            return content;
        }
        return content;
    }

    /**
     * 去除所有的HTML 代码
     * @param content
     * @return
     */
    public static String replseAllHtml(String content){
        try {
            if(StringUtils.isBlank(content)){
                return "";
            }
            return Jsoup.clean(content, Whitelist.none());
        }catch (Exception e){
            //LOGGER.error(e.getMessage());
            return content;
        }
    }

    public static boolean isMatcher(String content){
        Matcher mImage = P_IMAGE.matcher(content);
        return mImage.find();
    }

    public static void main(String args[]){
        System.out.println(replseAllHtml("<div class=\"home-container\">dfdfdf</div>"));
    }
}
