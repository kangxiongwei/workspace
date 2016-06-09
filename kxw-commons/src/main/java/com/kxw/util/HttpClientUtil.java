package com.kxw.util;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HttpClient工具类
 * Created by kangxiongwei on 16/6/9 上午12:40.
 */
public class HttpClientUtil {

    /**
     * 发送GET请求工具
     *
     * @param url    请求地址
     * @param params 请求参数 如ref=abc&name=zhangsan
     * @return
     * @throws IOException
     */
    public static String sendGetRequest(String url, String params) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        if (params != null && !"".equals(params)) url += "?" + params;
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) response.close();
                if (httpClient != null) httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 发送POST请求
     *
     * @param url    请求地址
     * @param params 参数
     * @return
     */
    public static String sendPostRequest(String url, Map<String, String> params) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (String param : params.keySet()) {
            nvps.add(new BasicNameValuePair(param, params.get(param)));
        }
        CloseableHttpResponse response = null;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) response.close();
                if (httpClient != null) httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}
