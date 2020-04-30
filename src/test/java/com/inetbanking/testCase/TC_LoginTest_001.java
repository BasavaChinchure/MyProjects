package com.inetbanking.testCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.intetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		LoginPage lp=new LoginPage(driver);
		 lp.setUserName(username);
		 log.info("User name Entered");
		 lp.setPassword(password);
		 captureScreen(driver, "loginTest");
		 log.info("Password  Entered");
		 lp.clickSubmit();
		 Thread.sleep(3000);
		 log.info("Login Button Clicked");
		     Thread.sleep(2000);
		     if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
				{
					Assert.assertTrue(true);
					log.info("Login test passed");
				}
				else
				{
					//captureScreen(driver,"loginTest");
					captureScreen(driver, "loginTest");
					Assert.assertTrue(false);
					log.info("Login test failed");
				}
	}

}
