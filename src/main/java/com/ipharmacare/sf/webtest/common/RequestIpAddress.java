package com.ipharmacare.sf.webtest.common;
/**
 * 
 * @ClassName: RequestIpAddress 
 * @Description: 存贮访问请求的IP地址
 * @author DaiJunjun daijj@ipharmacare.net
 * @date 2017年4月19日 上午10:58:37 
 *
 */
public class RequestIpAddress {
	private static final String IpAddress = "http://120.26.216.119:10000";
	/**
	 * 
	 * @Title: getRequestIpAddress 
	 * @Description: RequestIpAddress的getter方法
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getRequestIpAddress() {  
        return IpAddress;  
    }  
}
