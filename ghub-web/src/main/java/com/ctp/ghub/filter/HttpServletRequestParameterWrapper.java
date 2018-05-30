package com.ctp.ghub.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/30
 */
public class HttpServletRequestParameterWrapper extends HttpServletRequestWrapper {

    public HttpServletRequestParameterWrapper(HttpServletRequest request) {
        super(request);
    }

    /**
     * 删除空白字符
     * @param parameter
     * @return
     */
    @Override
    public String[] getParameterValues(String parameter) {
        String[] results = super.getParameterValues(parameter);
        if (results == null) {
            return null;
        }
        int count = results.length;
        String[] trimResults = new String[count];

        for (int i = 0; i < count; i++) {
            trimResults[i] = results[i].trim();
        }
        return trimResults;
    }

    /**
     * 覆盖getParameter方法，将请求参数名和参数值都做xss过滤
     * @param name
     * @return
     */
    @Override
    public String getParameter(String name) {
        String value = super.getParameter(xssEncode(name));
        if (value != null) {
            value = xssEncode(value);
        }
        return value;
    }

    /**
     * 覆盖getHeader方法，将请求头中参数名和参数值都做xss过滤
     * @param name
     * @return
     */
    @Override
    public String getHeader(String name) {
        String value = super.getHeader(xssEncode(name));
        if (value != null) {
            value = xssEncode(value);
        }
        return value;
    }

    private String xssEncode(String value) {
        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        value = value.replaceAll("'", "&#39;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("script", "");
        return value;
    }
}
