package com.ipharmacare.sf.webtest.common;

/**
 * 
 * @ClassName: RequestCookies 
 * @Description: 获取当前会话的Cookies 
 * @author DaiJunjun daijj@ipharmacare.net
 * @date 2017年4月19日 上午10:54:29 
 *
 */
public class RequestAuditPlanLeastId  {
	private static String leastid = null;
	/**
	 * 
	 * @Title: getLeastId 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getLeastId() {  
        return leastid;  
    } 
	/**
	 * 
	 * @Title: setLeastId 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param id    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public static void setLeastId(String id) {  
		leastid=id;
    }  
}
