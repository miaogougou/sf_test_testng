package com.ipharmacare.sf.webtest;


import java.util.HashMap;
import java.util.Random;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import com.ipharmacare.sf.webtest.common.*;
import com.ipharmacare.sf.webtest.common.ResponseEntity.StatusInfo;



public class getAuditPlanMapTest {
    
    public String Code=null,Data=null,Msg=null,Result=null,Name=null,planname=null;
    getAuditPlanMap req=new getAuditPlanMap();
    
    @Test(groups = { "BaseCase1"})
    public void GetAuditPlanMap_Succ() throws Exception{
        Data=resultCheck(StatusInfo.REQUEST_SUCCESS); 
        try {
        	JsonParser parser=new JsonParser(); 
            JsonArray array=(JsonArray) parser.parse(Data);
            for(int i=0; i<array.size();i++) {
            	JsonObject subObject=array.get(i).getAsJsonObject();
            	String id = subObject.get("id").getAsString();
            	String name = subObject.get("name").getAsString();
        	    System.out.println("id="+id);
                System.out.println("name="+name); 
                RequestPlanMap.put(id,name);
            }
             
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
       System.out.println(RequestPlanMap.getPlanMap().toString());
    }
     
    public String resultCheck( StatusInfo statusInfo ) throws Exception{
        Result=req.getHttpRespone(planname);  
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
        return Data;
    }
}