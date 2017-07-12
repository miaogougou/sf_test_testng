package com.ipharmacare.sf.webtest;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import com.ipharmacare.sf.webtest.common.*;
import com.ipharmacare.sf.webtest.common.ResponseEntity.StatusInfo;



public class delAuditPlanTest {
    
    public String Code=null,Data=null,Msg=null,Result=null,id=null;
    delAuditPlan req=new delAuditPlan();
    
    @Test(groups = { "BaseCase1"})
    public void delAuditPlan_Succ() throws Exception{
    	id=null;
    	Iterator iter=RequestPlanMap.getPlanMap().entrySet().iterator();
    	while (iter.hasNext()) {
    		Map.Entry entry = (Map.Entry) iter.next();
    		Object key = entry.getKey();
    		Object val = entry.getValue();
    		id = (String) key;
    	}
        if(id == null) {
           System.out.println("没有可以删除的审方列表！");
        } else {
            resultCheck(id,StatusInfo.REQUEST_SUCCESS); 
            System.out.println(RequestPlanMap.getPlanMap().toString());
        }            
      
    }
     
    public void resultCheck( String id ,StatusInfo statusInfo ) throws Exception{
        Result=req.getHttpRespone(id);  
        Reporter.log("请求地址: "+req.geturl());
        Reporter.log("返回结果: "+Result);
        System.out.println("请求地址: "+req.geturl());
        System.out.println("返回结果: "+Result);
        Code=Common.getJsonValue(Result, "code");
        Data=Common.getJsonValue(Result, "data");
        Msg=Common.getJsonValue(Result, "message");
        if(null != statusInfo ) {
        	Assert.assertEquals(Code,statusInfo.getCode()); 
            Assert.assertEquals(Msg,statusInfo.getMessage());
        }
    }
}