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



public class getDrugPropertyListTest {
    
    public String Code=null,Data=null,Msg=null,Result=null,keyword=null;
    getDrugPropertyList req=new getDrugPropertyList();
    
    
    @Parameters({"keyword"})
	@Test(groups = { "BaseCase1"})
    public void getDrugPropertyList_Succ(String keyword) throws Exception{
        resultCheck(keyword,StatusInfo.REQUEST_SUCCESS); 
    }
     
    public void resultCheck(String keyword, StatusInfo statusInfo ) throws Exception{
        Result=req.getHttpRespone(keyword);  
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
