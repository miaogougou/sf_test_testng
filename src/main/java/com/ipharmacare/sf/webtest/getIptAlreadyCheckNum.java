package com.ipharmacare.sf.webtest;
import java.io.BufferedReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import sun.misc.BASE64Encoder;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.net.URI;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.ipharmacare.sf.webtest.common.*;
/**
 * 
 * @ClassName: getIptAlreadyCheckNum 
 * @Description: 住院已复核数
 * @author DaiJunjun daijj@ipharmacare.net
 * @date 2017年4月19日 上午11:30:19 
 *
 */
public class getIptAlreadyCheckNum {	
	private String url="";
	/**
	 * @Title: geturl 
	 * @Description: 访问的URL的getter方法 
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
    public String geturl() {
        return url;
    }
    /**
     * @throws Exception 
     * 
     * @Title: getHttpRespone 
     * @Description: 获取请求返回值
     * @param @return
     * @param @throws IOException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    public String getHttpRespone() throws Exception {
    	BasicCookieStore cookieStore = RequestCookiestore.getRequestCookies();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build();
        url=GetRequestUrl.getRequestUrl("/api/v1/analysis/ipt/getAlreadyCheckNum"); 
        
        try {
        	HttpUriRequest req = RequestBuilder.get()
                    .setUri(new URI(url))
                    .build();
        	CloseableHttpResponse response = httpclient.execute(req);
            try {
            	HttpEntity entity = response.getEntity();
            	
                System.out.println("getAlreadyCheckNum form get: " + response.getStatusLine());
                String Results=EntityUtils.toString(entity);
                //查看cookies 
                System.out.println("get of cookies:");
                List<Cookie> cookies = cookieStore.getCookies();
                if (cookies.isEmpty()) {
                    System.out.println("None");
                } else {
                    for (int i = 0; i < cookies.size(); i++) {
                        System.out.println("- " + cookies.get(i).toString());
                    }
                }
                return Results;
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }      
    }
}
