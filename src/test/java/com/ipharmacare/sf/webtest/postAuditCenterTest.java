package com.ipharmacare.sf.webtest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.io.File;

import com.ipharmacare.sf.webtest.common.*;
import com.ipharmacare.sf.webtest.common.ResponseEntity.StatusInfo;

public class postAuditCenterTest {
    
    public String Code=null,Data=null,Msg=null,Result=null;
    public String filename=null;
    postAuditCenter req=new postAuditCenter();
    
    @Test(groups = { "BaseCase1"})
    public void PostAuditCenter_Succ() throws IOException{
        File directory = new File("");//参数为空 
        String courseFile = directory.getCanonicalFile().getParent(); 
    	filename=courseFile+"/doc/body.txt";
        System.out.println(courseFile);
    	System.out.println(filename);
        resultCheck(filename,"200");
    }
   
    public void resultCheck(String filename,String code ) throws IOException{
        Result=req.getHttpRespone(filename);  
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
