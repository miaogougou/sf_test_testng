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



public class putAuditPlanTest {
    
    public String Code=null,Data=null,Msg=null,Result=null;
    putAuditPlan req=new putAuditPlan();
    
    
    @Parameters({"id"})
	@Test(groups = { "BaseCase1"})
    public void putAuditPlan_Succ(String id) throws Exception{
    	JsonArray jarry = new JsonArray();  
    	JsonObject jobj = new JsonObject();  
    	JsonObject infoList = new JsonObject(); 
        jobj.addProperty("id", 0); 
        jobj.addProperty("name", "junjun-住院-测试7"); 
        jobj.addProperty("category", 1); 
        jobj.addProperty("recipeSource", 1);
        infoList.addProperty("message", "相互作用");
        infoList.addProperty("symbol", "<");
        infoList.addProperty("analysisType", "适宜性分析");
        infoList.addProperty("severity", 7);
        infoList.addProperty("cautionStatus", "全部");
        jarry.add(infoList); 
        jobj.add("infoList",jarry);
    	System.out.println(jobj.toString());
    	System.out.println(jobj.get("name"));
        //resultCheck(id,jobj.toString(),StatusInfo.REQUEST_SUCCESS,"true"); 
        resultCheck(id,jobj.toString(),StatusInfo.REQUEST_NORESOURCE,null); 
    }
     
    public void resultCheck(String id,String body, StatusInfo statusInfo,String data ) throws Exception{
        Result=req.getHttpRespone(id,body);  
        Reporter.log("请求地址: "+req.geturl());
        Reporter.log("返回结果: "+Result);
        System.out.println("请求地址: "+req.geturl());
        System.out.println("返回结果: "+Result);
        Code=Common.getJsonValue(Result, "code");
        Data=Common.getJsonValue(Result, "data");
        Msg=Common.getJsonValue(Result, "message");
        if(null != statusInfo ) {
        	Assert.assertEquals(Code,statusInfo.getCode()); 
            //Assert.assertEquals(Msg,statusInfo.getMessage());
        }
            Assert.assertEquals(Data,data);
    }
}
