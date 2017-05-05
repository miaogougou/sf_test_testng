package com.ipharmacare.sf.webtest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ipharmacare.sf.webtest.common.*;
import com.ipharmacare.sf.webtest.common.ResponseEntity.StatusInfo;


public class LoginTest {
    public String Result= null,username=null,password=null,zoneid=null;
    public String Code=null,Data=null,Msg=null;
    Login req=new Login();
    
   /**
    *  
    * @Title: getMethodName 
    * @Description: 打印方法的名称 
    * @param @param m
    * @param @return    设定文件 
    * @return Object[][]    返回类型 
    * @throws
    */
    @DataProvider(name = "mn")
    public Object[][] getMethodName(Method m) {
      System.out.println("<--------------------"+m.getName()+"-------------------->");  // print test method name
      return new Object[][] { new Object[] {}};
    }
    /**
     * 
     * @Title: login_Succ 
     * @Description: 登录成功
     *                   用户名  正确
     *                   密码    正确
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "flowcase"},dataProvider = "mn")
    public void login_Succ() throws Exception{
        username="daijj";
        password="ipharmacare";
        resultCheck(username, password,null,StatusInfo.REQUEST_SUCCESS);
    }
    /**
     * 
     * @Title: login_MissUser 
     * @Description: 登录失败
     *                   用户名  缺失
     *                   密码    正确 
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_MissUser() throws Exception{
        username="";
        password="ipharmacare";
        resultCheck(username, password,null,StatusInfo.REQUEST_LOGIN_AUTHORIZE_FAILED);
    }
    /**
     * 
     * @Title: login_SpaceUSpace 
     * @Description: 登录失败
     *                   用户名  空格
     *                   密码    正确 
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_SpaceUSpace() throws Exception{
        username="   ";
        password="ipharmacare";
        resultCheck(username, password,null,null);
    }
    /**
     * 
     * @Title: login_SpacePSpace 
     * @Description: 登录失败
     *                   用户名  正确
     *                   密码    空格  
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_SpacePSpace() throws Exception{
        username="daijj";
        password="   ";
        resultCheck(username, password,null,StatusInfo.REQUEST_LOGIN_AUTHORIZE_FAILED);
    }
    /**
     * 
     * @Title: login_MissPwd 
     * @Description: 登录失败
     *                   用户名  正确
     *                   密码    缺失  
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_MissPwd() throws Exception{
        username="daijj";
        password="";
        resultCheck(username, password,null,StatusInfo.REQUEST_LOGIN_AUTHORIZE_FAILED);
    }
    /**
     * 
     * @Title: login_IllegalUser 
     * @Description: 登录失败
     *                   用户名  不正确
     *                   密码    不正确   
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_IllegalUser() throws Exception{
        username="daijunjun";
        password="123456789";
        resultCheck(username, password,null,StatusInfo.REQUEST_LOGIN_AUTHORIZE_FAILED);
    }
    /**
     * 
     * @Title: login_IllegalUserName 
     * @Description: 登录失败
     *                   用户名  不正确
     *                   密码    正确  
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_IllegalUserName() throws Exception{
        username="daijunjun";
        password="ipharmacare";
        resultCheck(username, password,null,StatusInfo.REQUEST_LOGIN_AUTHORIZE_FAILED);
    }
    /**
     * 
     * @Title: login_IllegalPwd 
     * @Description: 登录失败
     *                   用户名  正确
     *                   密码    不正确  
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_IllegalPwd() throws Exception{
        username="daijj";
        password="123456789";
        resultCheck(username, password,null,StatusInfo.REQUEST_LOGIN_AUTHORIZE_FAILED);
    }
    /**
     * 
     * @Title: login_SpaceUser 
     * @Description:请求失败
     *                   用户名  前面空格
     *                   密码    正确
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_SpaceUser() throws Exception{
        username="   daijj";
        password="ipharmacare";
        resultCheck(username, password,null,null);
    }
    /**
     * 
     * @Title: login_UserSpace 
     * @Description: 请求失败
     *                   用户名  后面空格
     *                   密码    正确 
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_UserSpace() throws Exception{
        username="daijj   ";
        password="ipharmacare";
        resultCheck(username, password,null,null);
    }
    /**
     * 
     * @Title: login_SpUserace 
     * @Description: 请求失败
     *                   用户名  前后空格
     *                   密码    正确 
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_SpUserace() throws Exception{
        username="   daijj   ";
        password="ipharmacare";
        resultCheck(username, password,null,null);
    }
    /**
     * 
     * @Title: login_UsSpaceer 
     * @Description: 登录失败
     *                   用户名  中间空格
     *                   密码    正确 
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_UsSpaceer() throws Exception{
        username="dai  jj";
        password="ipharmacare";
        resultCheck(username, password,null,null);
    }
    /**
     * 
     * @Title: login_SpacePwd 
     * @Description: 登录失败
     *                   用户名  正确
     *                   密码    前面空格 
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_SpacePwd() throws Exception{
        username="daijj";
        password="   ipharmacare";
        resultCheck(username, password,null,StatusInfo.REQUEST_LOGIN_AUTHORIZE_FAILED);
    }
    /**
     * 
     * @Title: login_PwdSpace 
     * @Description: 登录失败
     *                   用户名  正确
     *                   密码    后面空格 
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_PwdSpace() throws Exception{
        username="daijj";
        password="ipharmacare   ";
        resultCheck(username, password,null,StatusInfo.REQUEST_LOGIN_AUTHORIZE_FAILED);
    }
    /**
     * 
     * @Title: login_SpPwdace 
     * @Description: 登录失败
     *                   用户名  正确
     *                   密码    前后空格 
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_SpPwdace() throws Exception{
        username="daijj";
        password="   ipharmacare   ";
        resultCheck(username, password,null,StatusInfo.REQUEST_LOGIN_AUTHORIZE_FAILED);
    }
    /**
     * 
     * @Title: login_PwSpaced 
     * @Description: 登录失败
     *                   用户名  正确
     *                   密码    中间空格
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_PwSpaced() throws Exception{
        username="daijj";
        password="ipharm  acare";
        resultCheck(username, password,null,StatusInfo.REQUEST_LOGIN_AUTHORIZE_FAILED);
    }
    /**
     * 
     * @Title: login_zoneidNotmatch 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_zoneidNotmatch() throws Exception{
        username="daijj";
        password="ipharmacare";
        zoneid = "3";
        resultCheck(username, password,zoneid,StatusInfo.REQUEST_SUCCESS);
    }
    /**
     * 
     * @Title: login_zoneidMatch 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_zoneidMatch() throws Exception{
        username="daijj";
        password="ipharmacare";
        zoneid = "1";
        resultCheck(username, password,zoneid,StatusInfo.REQUEST_SUCCESS);
    }
    /**
     * 
     * @Title: login_zoneidFail 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    @Test(groups = { "BaseCase"},dataProvider = "mn")
    public void login_zoneidFail() throws Exception{
        username="asdf";
        password="daijj";
        zoneid = "5";
        resultCheck(username, password,zoneid,StatusInfo.REQUEST_LOGIN_AUTHORIZE_FAILED);
    }
    /**
     * 
     * @Title: resultCheck 
     * @Description: 检查点 
     * @param @param username
     * @param @param password
     * @param @param zoneid
     * @param @param statusInfo
     * @param @throws Exception    设定文件 
     * @return void    返回类型 
     * @throws
     */
    public void resultCheck(String username, String password, String zoneid, StatusInfo statusInfo) throws Exception{
        Result=req.getHttpRespone(username, password, zoneid);
        Reporter.log("请求地址: "+req.getmagicnourl());
        Reporter.log("请求地址: "+req.getloginurl());
        Reporter.log("返回结果: "+Result);
        System.out.println("请求地址: "+req.getloginurl());
        System.out.println("返回结果: "+Result);
        Code=Common.getJsonValue(Result, "code");
        Msg=Common.getJsonValue(Result, "message");
        Data=Common.getJsonValue(Result, "data");
        if(null != statusInfo) {
            Assert.assertEquals(Code,statusInfo.getCode()); 
            Assert.assertEquals(Msg,statusInfo.getMessage());
        }
    }
}