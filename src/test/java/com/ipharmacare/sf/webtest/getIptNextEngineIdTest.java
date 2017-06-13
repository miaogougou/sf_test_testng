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



public class getIptNextEngineIdTest {
    
    public String Code=null,Data=null,Msg=null,Result=null,engineId=null;
    getIptNextEngineId req=new getIptNextEngineId();
    
    
    @Parameters({"engineId"})
	@Test(groups = { "BaseCase1"})
    public void getIptNextEngineId_Succ(String engineId) throws Exception{
        resultCheck(engineId,StatusInfo.REQUEST_SUCCESS); 
    }
     
    public void resultCheck(String engineId, StatusInfo statusInfo ) throws Exception{
        Result=req.getHttpRespone(engineId);  
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
