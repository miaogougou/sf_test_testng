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



public class getOptAroundAuditResultallTest {
    
    public String Code=null,Data=null,OptAroundAuditResultall=null,Result=null,aroundAuditResultId=null;
    getOptAroundAuditResultall req=new getOptAroundAuditResultall();
    
    
    @Parameters({"aroundAuditResultId"})
	@Test(groups = { "BaseCase1"})
    public void getOptAroundAuditResultall_Succ(String aroundAuditResultId) throws Exception{
        resultCheck(aroundAuditResultId,StatusInfo.REQUEST_SUCCESS); 
    }
     
    public void resultCheck(String aroundAuditResultId, StatusInfo statusInfo ) throws Exception{
        Result=req.getHttpRespone(aroundAuditResultId);  
        Reporter.log("请求地址: "+req.geturl());
        Reporter.log("返回结果: "+Result);
        System.out.println("请求地址: "+req.geturl());
        System.out.println("返回结果: "+Result);
        Code=Common.getJsonValue(Result, "code");
        Data=Common.getJsonValue(Result, "data");
        OptAroundAuditResultall=Common.getJsonValue(Result, "message");
        if(null != statusInfo ) {
        	Assert.assertEquals(Code,statusInfo.getCode()); 
            Assert.assertEquals(OptAroundAuditResultall,statusInfo.getMessage());
        }
    }
}
