package com.ctp.ghub.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chengtianping
 * @description
 * @date 2018/5/21
 */
public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static Integer connectionRequestTimeout = 3000;

    private static Integer socketTimeOut = 3000;

    private static Integer connectTimeout = 3000;

    /**
     * 模拟Get 请求
     * @param url
     * @return
     */
    public static String doGet(String url){
        //单位毫秒
        RequestConfig requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(connectionRequestTimeout).setConnectTimeout(connectTimeout)
            .setSocketTimeout(socketTimeOut).build();

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);

        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            } else {
                String result = EntityUtils.toString(response.getEntity(), "UTF-8");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error("IOException exception -- > " + e);
                }
            }
        }
        return null;
    }

    /**
     * 模拟post请求
     * @param url
     * @param jsonContent
     * @return
     */
    public static String doPost(String url, String jsonContent){
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeOut).setConnectTimeout(connectTimeout).build();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-Type", "application/json");
        StringEntity requestEntity = new StringEntity(jsonContent, "utf-8");
        httpPost.setEntity(requestEntity);
        try {
            response = httpClient.execute(httpPost, new BasicHttpContext());
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String resultStr = EntityUtils.toString(entity, "utf-8");
                return resultStr;
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("httpPostJson exception -- > " + e);
            return null;
        } finally {
            if (response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error("IOException exception -- > " + e);
                }
            }
        }
    }
}
