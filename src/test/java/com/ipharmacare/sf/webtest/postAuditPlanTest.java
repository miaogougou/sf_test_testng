package com.ipharmacare.sf.webtest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import com.ipharmacare.sf.webtest.common.*;
import com.ipharmacare.sf.webtest.common.ResponseEntity.StatusInfo;

public class postAuditPlanTest {
    
    public String Code=null,Data=null,Msg=null,Result=null;
   
    postAuditPlan req=new postAuditPlan();
    /**
     * 
     * @Title: PostAuditPlanWithoutlogin_Fail 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @throws IOException    设定文件 
     * @return void    返回类型 
     * @throws
     */
    /*
    @BeforeSuite
    public void PostAuditPlanWithoutlogin_Fail() throws IOException{
	/*
	  {
	     "name":"测试测试哈",
		 "category":2,
		 "recipeSource":0,
		 "infoList":[
		     { 
			   "message":"相互作用",
			   "symbol":"<",
			   "analysisType":"适宜性分析",
			   "severity":7,
			   "cautionStatus":"全部"
			   }
		  ]
	   }
	  
    	JsonArray jarry = new JsonArray();  
    	JsonObject jobj = new JsonObject();  
    	JsonObject infoList = new JsonObject(); 
        jobj.addProperty("name", "测试测试哈");  
        jobj.addProperty("category", 2); 
        jobj.addProperty("recipeSource", 0);
        infoList.addProperty("message", "相互作用");
        infoList.addProperty("symbol", "<");
        infoList.addProperty("analysisType", "适宜性分析");
        infoList.addProperty("severity", 7);
        infoList.addProperty("cautionStatus", "全部");
        jarry.add(infoList); 
        jobj.add("infoList",jarry);
    	System.out.println(jobj.toString());
    	System.out.println(jobj.get("name"));
        resultCheck(jobj.toString(),"400");
    }
   */
    /**
     * 
     * @Title: PostAuditPlanCustemOne_Succ 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @param customname
     * @param @throws IOException    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Parameters({"customname"})
    @Test(groups = { "BaseCase1"})
    public void PostAuditPlanCustemOne_Succ(String customname) throws IOException{
    	JsonArray jarry = new JsonArray();  
    	JsonObject jobj = new JsonObject();  
    	JsonObject infoList = new JsonObject(); 
        jobj.addProperty("name", customname);  
        jobj.addProperty("category", 2); 
        jobj.addProperty("recipeSource", 0);
        infoList.addProperty("message", "相互作用");
        infoList.addProperty("symbol", "<");
        infoList.addProperty("analysisType", "适宜性分析");
        infoList.addProperty("severity", 7);
        infoList.addProperty("cautionStatus", "全部");
        jarry.add(infoList); 
        jobj.add("infoList",jarry);
    	System.out.println(jobj.toString());
    	System.out.println(jobj.get("name"));
        resultCheck(jobj.toString(),"200");
    }
    /**
     * 
     * @Title: PostAuditPlanOne_Succ 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @throws IOException    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"})
    public void PostAuditPlanOne_Succ() throws IOException{
    	JsonArray jarry = new JsonArray();  
    	JsonObject jobj = new JsonObject();  
    	JsonObject infoList = new JsonObject(); 
        jobj.addProperty("name", "测试测试2");  
        jobj.addProperty("category", 2); 
        jobj.addProperty("recipeSource", 0);
        infoList.addProperty("message", "相互作用");
        infoList.addProperty("symbol", "<");
        infoList.addProperty("analysisType", "适宜性分析");
        infoList.addProperty("severity", 7);
        infoList.addProperty("cautionStatus", "全部");
        jarry.add(infoList); 
        jobj.add("infoList",jarry);
    	System.out.println(jobj.toString());
    	System.out.println(jobj.get("name"));
        resultCheck(jobj.toString(),"200");
    }
    
    /**
     * 
     * @Title: PostAuditPlanMissname_Fail 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @throws IOException    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"})
    public void PostAuditPlanMissname_Fail() throws IOException{
    	JsonArray jarry = new JsonArray();  
    	JsonObject jobj = new JsonObject();  
    	JsonObject infoList = new JsonObject(); 
        jobj.addProperty("category", 2); 
        jobj.addProperty("recipeSource", 0);
        infoList.addProperty("message", "相互作用");
        infoList.addProperty("symbol", "<");
        infoList.addProperty("analysisType", "适宜性分析");
        infoList.addProperty("severity", 7);
        infoList.addProperty("cautionStatus", "全部");
        jarry.add(infoList); 
        jobj.add("infoList",jarry);
    	System.out.println(jobj.toString());
    	System.out.println(jobj.get("name"));
        resultCheck(jobj.toString(),"200");
    }
    
    public void resultCheck(String body,String code ) throws IOException{
        Result=req.getHttpRespone(body);  
        Reporter.log("请求地址: "+req.geturl());
        Reporter.log("返回结果: "+Result);
        System.out.println("请求地址: "+req.geturl());
        System.out.println("返回结果: "+Result);
        Code=Common.getJsonValue(Result, "code");
        Data=Common.getJsonValue(Result, "data");
        Msg=Common.getJsonValue(Result, "message");
        Assert.assertEquals(Code,code);        
    }
}
