package com.ipharmacare.sf.webtest.common;

import org.apache.http.impl.client.BasicCookieStore;

/**
 * 
 * @ClassName: RequestCookies 
 * @Description: 获取当前会话的Cookies 
 * @author DaiJunjun daijj@ipharmacare.net
 * @date 2017年4月19日 上午10:54:29 
 *
 */
public class RequestCookiestore  {
	private static  BasicCookieStore Cookiestore = new BasicCookieStore();
	/**
	 * 
	 * @Title: getRequestCookies 
	 * @Description: RequestCookies的getter方法 
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static BasicCookieStore getRequestCookies() {  
        return Cookiestore;  
    } 
	/**
	 * 
	 * @Title: setRequestCookies 
	 * @Description: RequestCookies的setter方法
	 * @param @param cookie    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public static void setRequestCookies(BasicCookieStore cookieStore) {  
		Cookiestore=cookieStore;
    }  
}
