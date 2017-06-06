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



public class getIptReviewResultListTest {
    
    public String Code=null,Data=null,Msg=null,Result=null;
    getIptReviewResultList req=new getIptReviewResultList();
    
    
    @Parameters({"startTime","endTime","page","pageSize",
				"checkPeopleName","checkResult","source"})
	@Test(groups = { "BaseCase1"})
    public void getIptReviewResultList_Succ(String startTime,String endTime,
			                                String page,String pageSize,
											String checkPeopleName,														                      String checkResult,String source) throws Exception{
        resultCheck(startTime,endTime,page,pageSize,
				    checkPeopleName,checkResult,source,  
				    StatusInfo.REQUEST_SUCCESS); 
    }
     
    public void resultCheck(String startTime,String endTime,
			                String page,String pageSize,
							String checkPeopleName,														                      String checkResult,String source,
			                StatusInfo statusInfo ) throws Exception{
        Result=req.getHttpRespone(startTime,endTime,page,pageSize,
				                 checkPeopleName,checkResult,source);  
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
