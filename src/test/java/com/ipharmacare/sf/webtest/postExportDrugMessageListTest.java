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
public class postExportDrugMessageListTest {
    
    public String Code=null,Data=null,Msg=null,Result=null;
   
    postExportDrugMessageList req=new postExportDrugMessageList();
    /**
     * 
     * @Title: PostExportDrugMessageList_Succ 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @param customname
     * @param @throws IOException    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase1"})
    public void PostExportDrugMessageList_Succ() throws Exception{
	/*
	 {
		"startTime": 0,
		"endTime": 0,
		"doctorName": "string",
		"drugIdArr": [
		"string"
		],
	    "productName": "string",
		 "deptId": [
		 0
		 ],
		"zoneIdWard": [
		 0
		],
	    "wardId": [
		 0
		 ],
		"zoneId": [
		0
		],
	  "antibacterialsFlag": 0,
	  "injectableFlag": 0,
	  "highriskFlag": 0,
	  "recipeNo": "string",
	  "page": 0,
	  "pageSize": 0,
	  "patientId": "string",
	  "auditDocId": "string",
	  "recipeStatus": "string",
	  "orderStatus": "string",
	  "eventNo": "string",
	  "start": 0
	}
	*/
    	JSONObject jobj = new JSONObject();  
    	JSONArray drugIdArr = new JSONArray(); 
    	JSONArray deptId = new JSONArray(); 
    	JSONArray zoneIdWard = new JSONArray(); 
    	JSONArray zoneId = new JSONArray(); 
    	JSONArray wardId = new JSONArray(); 
		jobj.put("startTime", 0);
		jobj.put("endTime", 0);
		jobj.put("doctorName", "string");
	    jobj.put("antibacterialsFlag", 0);
	    jobj.put("injectableFlag", 0);
	    jobj.put("highriskFlag", 0);
	    jobj.put("recipeNo", "string");
	    jobj.put("page", 0);
	    jobj.put("pageSize", 0);
	    jobj.put("patientId", "string");
	    jobj.put("auditDocId", "string");
	    jobj.put("recipeStatus", "string");
	    jobj.put("orderStatus", "string");
	    jobj.put("eventNo", "string");
	    jobj.put("start", 0);
	    jobj.put("productName", "string");
        drugIdArr.add("1234"); 
        deptId.add("0"); 
        zoneIdWard.add("0"); 
        wardId.add("0"); 
        zoneId.add("0"); 
        jobj.element("drugIdArr",drugIdArr);
        jobj.element("deptId",deptId);
        jobj.element("zoneIdWard",zoneIdWard);
        jobj.element("wardId",wardId);
        jobj.element("zoneId",zoneId);
    	System.out.println(jobj.get("dugIdArr"));
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
