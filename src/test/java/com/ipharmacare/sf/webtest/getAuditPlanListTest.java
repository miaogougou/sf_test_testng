package com.ipharmacare.sf.webtest;

import java.io.IOException;
import java.util.Random;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import com.ipharmacare.sf.webtest.common.*;
import com.ipharmacare.sf.webtest.common.ResponseEntity.StatusInfo;


import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class getAuditPlanListTest {
    
    public String Code=null,Data=null,Msg=null,Result=null,Id=null,Name=null;
    getAuditPlanList req=new getAuditPlanList();
    
    @Test(groups = { "BaseCase1"})
    public void GetAuditPlanListAll_Succ() throws IOException{
    	Id=null;
        Data=resultCheck(Id,StatusInfo.REQUEST_SUCCESS);
        try {
        	JsonParser parser=new JsonParser(); 
            JsonObject obj=(JsonObject) parser.parse(Data);
            JsonArray array=obj.get("recordList").getAsJsonArray();
            //随机查看一个存在的方案
            int num = new Random().nextInt(array.size());
            for(int i=0; i<array.size();i++) {
            	JsonObject subObject=array.get(i).getAsJsonObject();
        	    System.out.println("id="+subObject.get("id").getAsString());
                System.out.println("name="+subObject.get("name").getAsString());
                if( i== 0) {
                	RequestAuditPlanLeastId.setLeastId(subObject.get("id").getAsString());
                }
                if(i == num) {
                	//设置随机方案id
                	Id = subObject.get("id").getAsString();
                	//设置随机方案name
                    Name= subObject.get("name").getAsString(); 
                }
            }
             
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }
    
    @Test(groups = { "BaseCase"},dependsOnMethods = { "GetAuditPlanListAll_Succ" })
    public void GetAuditPlanListRandomOne_Succ() throws IOException{
    	System.out.println("查看随机方案Id:"+Id);  
        System.out.println("查看随机方案Name:"+Name); 
        Reporter.log("查看随机方案Id:"+Id); 
        Reporter.log("查看随机方案Name:"+Name); 
        String Dataone=resultCheck(Id,StatusInfo.REQUEST_SUCCESS);
        //验证随机方案的id和name是否统一        
        Assert.assertEquals(Name,Common.getJsonValue(Dataone, "name"));
    }

    @Test(groups = { "BaseCase1"},dependsOnMethods = { "GetAuditPlanListAll_Succ" })
    public void GetAuditPlanListLeastOne_Succ() throws IOException{
    	String leastid = RequestAuditPlanLeastId.getLeastId();
    	if(null!=leastid && ""!=leastid) {
    		System.out.println("查看最新方案id:"+leastid);   
            Reporter.log("查看最新方案id:"+leastid); 
            String Dataone=resultCheck(leastid,StatusInfo.REQUEST_SUCCESS);
        //验证最新方案的id是否一致        
        Assert.assertEquals(leastid,Common.getJsonValue(Dataone, "id"));
    	}
    }
    
    @Test(groups = { "BaseCase"},dependsOnMethods = { "GetAuditPlanListAll_Succ" })
    public void GetAuditPlanListOne_Fail() throws IOException{
        String Dataone=resultCheck("123",null);
        Assert.assertEquals("null",Dataone);
    }
    
    @Parameters({"customid","customname"})
    @Test(groups = { "BaseCase"},dependsOnMethods = { "GetAuditPlanListAll_Succ" })
    public void GetAuditPlanListCustomOne_Succ(String customid,String customname) throws IOException{
    	System.out.println("查看用户方案Id:"+customid);  
        System.out.println("查看用户方案Name:"+customname); 
        Reporter.log("查看用户方案Id:"+customid); 
        Reporter.log("查看用户方案Name:"+customname); 
        String Dataone=resultCheck(customid,StatusInfo.REQUEST_SUCCESS);
        //验证用户方案的id和name是否统一        
        Assert.assertEquals(customname,Common.getJsonValue(Dataone, "name"));
    }

    @Parameters({"customname"})
    @Test(groups = { "BaseCase"},dependsOnMethods = { "GetAuditPlanListAll_Succ" })
    public void GetAuditPlanListCheckLeastone(String customname) throws IOException{
    	String leastid = RequestAuditPlanLeastId.getLeastId();
    	if(null!=leastid && ""!=leastid) {
    		System.out.println("查看用户方案Id:"+leastid);  
            Reporter.log("查看用户方案Id:"+leastid); 
            String Dataone=resultCheck(leastid,StatusInfo.REQUEST_SUCCESS);
            //验证用户方案的id和name是否统一        
            Assert.assertEquals(customname,Common.getJsonValue(Dataone, "name"));
    	}
    }
    public String resultCheck(String Id, StatusInfo statusInfo ) throws IOException{
        Result=req.getHttpRespone(Id);  
        Reporter.log("请求地址: "+req.geturl());
        Reporter.log("返回结果: "+Result);
        System.out.println("请求地址: "+req.geturl());
        System.out.println("返回结果: "+Result);
        Code=Common.getJsonValue(Result, "code");
        Data=Common.getJsonValue(Result, "data");
        Msg=Common.getJsonValue(Result, "message");
        if(null != statusInfo) {
        	Assert.assertEquals(Code,statusInfo.getCode()); 
            Assert.assertEquals(Msg,statusInfo.getMessage());
        } 
        return Data; 
    }
}