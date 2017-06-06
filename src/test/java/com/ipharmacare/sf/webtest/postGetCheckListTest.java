package com.ipharmacare.sf.webtest;


import java.io.IOException;
import java.util.Random;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import com.ipharmacare.sf.webtest.common.*;
import com.ipharmacare.sf.webtest.common.ResponseEntity.StatusInfo;
public class postGetCheckListTest {
    
    public String Code=null,Data=null,Msg=null,Result=null;
   
    postGetCheckList req=new postGetCheckList();
    /**
     * 
     * @Title: PostGetCheckList_Succ 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @param customname
     * @param @throws IOException    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase1"})
    public void PostGetCheckList_Succ() throws Exception{
    	JSONObject jobj = new JSONObject();  
    	JSONArray jarry = new JSONArray();  
        jobj.put("projectId", 0);  
        jobj.put("startTime", 0); 
        jobj.put("endTime", 0);
        jobj.put("source", 0);
		jobj.put("type", 0);
		jobj.put("randomNum", 0);
		jobj.put("resultPercentage", 0);
		jobj.put("userRealName", "string");
		jobj.put("userName", "string");
        jarry.add("1234"); 
        jarry.add("4321"); 
        jobj.element("auditIdList",jarry);
    	System.out.println(jobj.get("auditIdList"));
        resultCheck(jobj.toString(),StatusInfo.REQUEST_SUCCESS); 
    }
    
    public void resultCheck(String body,StatusInfo statusInfo ) throws Exception{
        Result=req.getHttpRespone(body);  
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
