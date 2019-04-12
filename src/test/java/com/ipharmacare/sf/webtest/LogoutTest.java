package com.ipharmacare.sf.webtest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ipharmacare.sf.webtest.common.*;
import com.ipharmacare.sf.webtest.common.ResponseEntity.StatusInfo;

public class LogoutTest {
    
    public String Code=null,Data=null,Msg=null,Result=null;
    Logout req=new Logout();
    /**
     * 
     * @Title: logout_Succ 
     * @Description: 前置登录成功，第一次正常退出
     *               "200", "OK"
     * @param @throws IOException    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "flowcase"},priority = 1)
    public void logout_Succ() throws IOException{
        resultCheck(StatusInfo.REQUEST_SUCCESS);
    }
    /**
     * 
     * @Title: logout_Fail 
     * @Description: 紧接着再退出一次，会提示鉴权失败，没有权限
     *               "405","鉴权失败"
     * @param @throws IOException    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},priority = 2)
    public void logout_Fail() throws IOException{
        resultCheck(StatusInfo.REQUEST_AUTHORIZE_FAILED);
    }
    /**
     * 
     * @Title: logout_Fail2 
     * @Description: TODO 内部异常，用例未成功建立
     *               "500", "服务器忙，请稍后再次尝试，或者跟管理员联系"
     * @param @throws IOException    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},priority = 2, enabled=false)
    public void logout_Exception() throws IOException{
        resultCheck(StatusInfo.BUSINESS_FAILURE);
    }
    public void resultCheck(StatusInfo statusInfo) throws IOException{
        Result=req.getHttpRespone();  
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
    }
}