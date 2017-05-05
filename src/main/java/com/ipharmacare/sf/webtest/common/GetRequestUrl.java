package com.ipharmacare.sf.webtest.common;
/**
 * 
 * @ClassName: GetRequestUrl 
 * @Description: 获取请求访问的URL
 * @author DaiJunjun daijj@ipharmacare.net
 * @date 2017年4月19日 上午11:28:03 
 *
 */
public class GetRequestUrl {
	/**
	 * @Title: getRequestUrl 
	 * @Description: 获取请求访问的URL 
	 * @param @param url
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getRequestUrl(String url) {  
        return (RequestIpAddress.getRequestIpAddress()+url);  
    }  
}
