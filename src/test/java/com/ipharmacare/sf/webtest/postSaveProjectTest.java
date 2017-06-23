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
public class postSaveProjectTest {
    
    public String Code=null,Data=null,Msg=null,Result=null;
   
    postSaveProject req=new postSaveProject();
    /**
     * 
     * @Title: PostSaveProject_Succ 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @param customname
     * @param @throws IOException    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Parameters({"projectName"})
    @Test(groups = { "BaseCase1"})
    public void PostSaveProject_Succ(String projectName) throws Exception{
		/*
		 * {
		 *   "projectId": 0,
		 *   "startTime": 0,
		 *   "endTime": 0,
		 *   "auditIdList": [
		 *      "1234","4321"
		 *    ],
		 *   "source": 0,
		 *   "type": 0,
		 *   "randomNum": 0,
		 *   "resultPercentage": 0,
		 *   "userRealName": "string",
		 *   "userName": "string"
		 *  }
		*/
    	JSONObject jobj = new JSONObject();  
    	JSONArray jarry = new JSONArray();  
        //jobj.put("projectId", 0);  
        jobj.put("startTime", "1497542400000"); 
        jobj.put("endTime", "1498233599999");
        jobj.put("source", 0);
		jobj.put("type", 3);
		jobj.put("randomNum", 3);
		//jobj.put("resultPercentage", 0);
		//jobj.put("userRealName", "string");
		//jobj.put("userName", "string");
        jarry.add("680"); 
        jobj.element("auditIdList",jarry);
    	System.out.println(jobj.get("auditIdList"));
        resultCheck(jobj.toString(),projectName,StatusInfo.REQUEST_SUCCESS); 
    }
    
    public void resultCheck(String body,String projectName,StatusInfo statusInfo ) throws Exception{
        Result=req.getHttpRespone(body,projectName);  
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
