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
 * @ClassName: Login 
 * @Description: 登录 
 * @author DaiJunjun daijj@ipharmacare.net
 * @date 2017年4月19日 上午10:45:54 
 *
 */
public class Login {
	private String magicnourl="";
	private String loginurl="";
	
    public String getmagicnourl() {
        return magicnourl;
    }
    public String getloginurl() {
        return loginurl;
    }
    /**
     * 
     * @Title: EncoderByMd5 
     * @Description: Md5加密
     * @param @param buf
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    public static String EncoderByMd5(String buf) {  
        try {  
            MessageDigest digist = MessageDigest.getInstance("MD5");  
            byte[] rs = digist.digest(buf.getBytes("UTF-8"));  
            StringBuffer digestHexStr = new StringBuffer();  
            for (int i = 0; i < 16; i++) {  
                digestHexStr.append(byteHEX(rs[i]));  
            }  
            return digestHexStr.toString();  
        } catch (Exception e) {  
             //logger.error(e.getMessage(), e);  
        }  
        return null;  
      
    }
    /**
     * 
     * @Title: byteHEX 
     * @Description: byte转成十六进制 
     * @param @param ib
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    public static String byteHEX(byte ib) {  
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };  
        char[] ob = new char[2];  
        ob[0] = Digit[(ib >>> 4) & 0X0F];  
        ob[1] = Digit[ib & 0X0F];  
        String s = new String(ob);  
        return s;  
    } 
   /**
    * 
    * @Title: getHttpRespone 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param username
    * @param @param password
    * @param @param zoneid
    * @param @return
    * @param @throws Exception    设定文件 
    * @return String    返回类型 
    * @throws
    */
    public String getHttpRespone(String username,String password, String zoneid) throws Exception {
    	String passwd = null;
        BasicCookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build();
        //获取随机码和加密后的密码
        magicnourl=GetRequestUrl.getRequestUrl("/api/v1/magicno");
        
        try {
        	HttpUriRequest magicnoreq = new HttpGet(magicnourl);
        	CloseableHttpResponse response = httpclient.execute(magicnoreq);
            try {
            	HttpEntity entity = response.getEntity();
            	
                System.out.println("magicno form get: " + response.getStatusLine());
                String magicnoResults=EntityUtils.toString(entity);
                //获取随机码
                String magicno=Common.getJsonValue(magicnoResults, "data");
                //密码进行Md5加密
                String md5_str1= EncoderByMd5(password);
                //加密后的密码加上随机码，再进行Md5加密，生成密码
                passwd = EncoderByMd5(md5_str1+magicno);
                System.out.println("Login passwd: " +passwd);
                //查看cookies 
                System.out.println("Initial set of cookies:");
                List<Cookie> cookies = cookieStore.getCookies();
                if (cookies.isEmpty()) {
                    System.out.println("None");
                } else {
                    for (int i = 0; i < cookies.size(); i++) {
                        System.out.println("- " + cookies.get(i).toString());
                    }
                }
            } finally {
                response.close();
            }
      
        
        //登录
        loginurl=GetRequestUrl.getRequestUrl("/api/v1/login"); 
        //输入用户名和加密后的密码
        HttpUriRequest login = RequestBuilder.post()
                .setUri(new URI(loginurl))
                .addParameter("name", username)
                .addParameter("password", passwd)
                .addParameter("zoneid", zoneid)
                .build();
        CloseableHttpResponse response1 = httpclient.execute(login);
        
        try {
        	HttpEntity entity1 = response1.getEntity(); 

            System.out.println("Login form get: " + response1.getStatusLine());
            String Results=EntityUtils.toString(entity1);
            System.out.println("Post login cookies:");
            //保存cookies，为之后测试操作做准备
            RequestCookiestore.setRequestCookies(cookieStore);
            //查看cookies
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
