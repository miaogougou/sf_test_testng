package com.ipharmacare.sf.webtest;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import sun.misc.BASE64Encoder;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.entity.*;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.ipharmacare.sf.webtest.common.*;


/**
 * 
 * @ClassName: postExtractIptCheckData 
 * @Description: 抽取住院复核数据
 * @author DaiJunjun daijj@ipharmacare.net
 * @date 2017年4月19日 下午3:07:39 
 *
 */
public class postExtractIptCheckData {	
	private String url="";
	/**
	 * @Title: geturl 
	 * @Description: 访问的URL的getter方法 
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
    public String geturl() {
        return this.url;
    }
    /**
     * 
     * @Title: getHttpRespone 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @param body
     * @param @return
     * @param @throws IOException    设定文件 
     * @return String    返回类型 
     * @throws
     */
    public String getHttpRespone(String body) throws IOException {
    	BasicCookieStore cookieStore = RequestCookiestore.getRequestCookies();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build();
        url=GetRequestUrl.getRequestUrl("/api/v1/analysis/ipt/extractIptCheckData");
        
        try {
            HttpPost httppost = new HttpPost(url);
            httppost.addHeader("Content-type","application/json; charset=utf-8");  
            httppost.setHeader("Accept", "application/json");  
            httppost.setEntity(new StringEntity(body, Charset.forName("UTF-8")));  
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
            	HttpEntity entity1 = response.getEntity(); 
                String Results=EntityUtils.toString(entity1);

                System.out.println("extractIptCheckData form post: " + response.getStatusLine());
                System.out.println("cookies:");
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
