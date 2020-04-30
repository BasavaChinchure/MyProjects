package com.intetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	 public LoginPage(WebDriver rdriver){
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath ="//input[@name='uid']")
	WebElement txtUserName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	
	WebElement lnkLogout;
	public void  setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	public void  setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void  clickSubmit() {
		btnLogin.click();
	}
	public void clickLogout() {
		
		lnkLogout.click();
		
	}

}
