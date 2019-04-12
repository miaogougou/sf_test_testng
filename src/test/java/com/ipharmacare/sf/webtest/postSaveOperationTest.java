package com.ipharmacare.sf.webtest;


import java.io.IOException;
import java.util.Random;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import com.ipharmacare.sf.webtest.common.*;
import com.ipharmacare.sf.webtest.common.ResponseEntity.StatusInfo;
public class postSaveOperationTest {
    
    public String Code=null,Data=null,Msg=null,Result=null;
   
    postSaveOperation req=new postSaveOperation();
    /**
     * 
     * @Title: PostSaveOperation_Succ 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @param customname
     * @param @throws IOException    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Parameters({"projectId"})
    @Test(groups = { "BaseCase1"})
    public void PostSaveOperation_Succ(String projectId) throws Exception{
    	JsonObject jobj = new JsonObject();  
        jobj.addProperty("id", 0);  
        jobj.addProperty("optRecipeId", 0); 
        jobj.addProperty("zoneId", 0);
        jobj.addProperty("deptId", "string");
		jobj.addProperty("deptName", "string");
		jobj.addProperty("doctorId", "string");
		jobj.addProperty("doctorName", "string");
		jobj.addProperty("patientId", "string");
		jobj.addProperty("patientName", "string");
		jobj.addProperty("pharmacistId", "string");
		jobj.addProperty("pharmacistName", "string");
		jobj.addProperty("checkResult", 0);
		jobj.addProperty("checkOpinion", "string");
		jobj.addProperty("checkPeopleId", "string");
	    jobj.addProperty("checkPeopleName", "string");
		jobj.addProperty("checkTime", "2017-06-02T02:03:30.913Z");
		System.out.println(jobj.toString());
    	System.out.println(jobj.get("checkTime"));
        resultCheck(jobj.toString(),projectId,StatusInfo.REQUEST_SUCCESS); 
    }
    
    public void resultCheck(String body,String projectId,StatusInfo statusInfo ) throws Exception{
        Result=req.getHttpRespone(body,projectId);  
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
