package com.ipharmacare.sf.webtest;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ipharmacare.sf.webtest.common.*;
import com.ipharmacare.sf.webtest.common.ResponseEntity.StatusInfo;



public class getCheckAuditPlanNameTest {
    
    public String Code=null,Data=null,Msg=null,Result=null,Name=null,planname=null;
    getCheckAuditPlanName req=new getCheckAuditPlanName();
    
    @Test(groups = { "BaseCase1"})
    public void GetcheckAuditPlanName_Fail() throws Exception{
    	planname = "ahahaha";
        resultCheck(planname,StatusInfo.REQUEST_SUCCESS,"false");       
    }
    @Test(groups = { "BaseCase1"})
    public void GetcheckAuditPlanName_Succ() throws Exception{
    	planname = "junjun-住院-测试7";
        //resultCheck(planname,StatusInfo.REQUEST_SUCCESS,"true");       
        resultCheck(planname,StatusInfo.REQUEST_SUCCESS,"false");       
    }
    
    public void resultCheck(String planname, StatusInfo statusInfo,String data ) throws Exception{
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
        if(null != data && "" != data) {
        	Assert.assertEquals(Data,data); 
        }
    }
}
