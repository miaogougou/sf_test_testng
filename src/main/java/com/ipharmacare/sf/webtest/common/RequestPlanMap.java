package com.ipharmacare.sf.webtest.common;

import java.util.HashMap;

/**
 * 
 * @ClassName: RequestPlanMap 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author DaiJunjun daijj@ipharmacare.net
 * @date 2017年5月3日 下午3:52:25 
 *
 */
public class RequestPlanMap  {
	private static  HashMap<String,String> planMap = new HashMap<String,String>();
	
	public static HashMap<String,String> getPlanMap() {  
        return planMap;  
    } 	
	public static void put(String id,String name) {  
		planMap.put(id,name);
    }  
	public static void clear(String id,String name) {  
		planMap.clear();
    } 
	public static String get(String id) {  
		return planMap.get(id);
    } 
}
