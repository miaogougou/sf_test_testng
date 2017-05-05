package com.ipharmacare.sf.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class LoginTest {
  
  WebDriver driver = new ChromeDriver();
 
  @BeforeTest
  public void launch()
  {		
    //Puts a Implicit wait, Will wait for 10 seconds before throwing exception
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //Launch website
    driver.navigate().to("http://120.26.216.119:10000");	
    driver.manage().window().maximize();
  }
		
  @Test
  public void login_Succ() throws IOException, InterruptedException
  {
	  //input zoneid
	  driver.findElement(By.xpath("/html/body/my-app/div[2]/div/div[2]/div/div/div[1]/input")).clear();
	  driver.findElement(By.xpath("/html/body/my-app/div[2]/div/div[2]/div/div/div[1]/input")).sendKeys("医院A");
	  //Select dropdown = new Select(driver.findElement(By.xpath("/html/body/my-app/div[2]/div/div[2]/div/div/div[1]/input")));
	  //dropdown.selectByValue("医院A");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
      //input username
	  driver.findElement(By.xpath("/html/body/my-app/div[2]/div/div[2]/div/div/div[2]/input")).clear();
      driver.findElement(By.xpath("/html/body/my-app/div[2]/div/div[2]/div/div/div[2]/input")).sendKeys("审方药师1");
      driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
      
      //input password
      driver.findElement(By.xpath("/html/body/my-app/div[2]/div/div[2]/div/div/div[3]/input")).clear();
      driver.findElement(By.xpath("/html/body/my-app/div[2]/div/div[2]/div/div/div[3]/input")).sendKeys("123456");
      driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
      
      //click login
      driver.findElement(By.xpath("/html/body/my-app/div[2]/div/div[2]/div/div/div[4]/button")).click(); 
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //sleep 5s,显示等待加载完成
      Thread.sleep(5000);
      Assert.assertEquals(driver.getCurrentUrl(), "http://120.26.216.119:10000/page/audit-setting");
     /*
      if (driver.getCurrentUrl().contentEquals("http://120.26.216.119:10000/page/audit-setting")) {
    	  System.out.println("success");
      } else{
    	  System.out.println("failure");
    	  System.out.println(driver.getCurrentUrl());
    	  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
          FileUtils.copyFile(scrFile, new File("/Users/daijunjun/Pictures/login.jpg"));
      } 
    */ 
  }
	
  @AfterTest
  public void terminatetest()
  {   
    driver.close();
  }
}