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
public class postSaveCheckResultTest {
    
    public String Code=null,Data=null,Msg=null,Result=null;
   
    postSaveCheckResult req=new postSaveCheckResult();
    /**
     * 
     * @Title: PostSaveCheckResult_Succ 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @param customname
     * @param @throws IOException    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase1"})
    public void PostSaveCheckResult_Succ() throws Exception{
    	JSONObject jobj = new JSONObject();  
		//jobj.put("id", 0);
		jobj.put("projectId", 15002);
		jobj.put("engineId", 155001);
		jobj.put("groupNo", "20170605b1_1");
		//jobj.put("zoneId", 0);
		//jobj.put("areaId", "string");
		//jobj.put("areaName", "string");
		//jobj.put("patientId", "string");
		//jobj.put("patientName", "string");
		//jobj.put("pharmacistId", "string");
		//jobj.put("pharmacistName", "string");
		jobj.put("checkResult", 1);
		//jobj.put("checkOpinion", "string");
		//jobj.put("checkPeopleId", "string");
		//jobj.put("checkPeopleName", "string");
    	//System.out.println(jobj.get("id"));
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
