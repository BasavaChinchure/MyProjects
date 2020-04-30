package com.inetbanking.testCase;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.Utilities.ReadConfig;

public class BaseClass {
	ReadConfig rc=new ReadConfig();
	public String baseURL=rc.getApplicationURL();
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	public static Logger log;
	public  static WebDriver driver;
	
	@SuppressWarnings("static-access")
	@Parameters("browser")
	@BeforeClass
	public void setUP(String br) throws MalformedURLException
	{
	
		//System.setProperty("webdriver.chrome.driver",r);
		
		//let me add Logger class
		 log=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		 if(br.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver",rc.getChromePath());
			 DesiredCapabilities dc = new DesiredCapabilities().chrome();

		        dc.setPlatform(Platform.WINDOWS);

		        URL url = new URL("http://localhost:4444/wd/hub");
		        // URL url = new URL("http://localhost:4444/wd/hub");

		        WebDriver driver = new RemoteWebDriver(url, dc);

			// driver=new ChromeDriver();
			 //driver.manage().window().maximize();
			 
		 }	else if(br.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",rc.getFirefoxPath());
				driver = new FirefoxDriver();
			}
			else if(br.equals("ie"))
			{
				
				System.setProperty("webdriver.ie.driver",rc.getIEPath());
				driver = new InternetExplorerDriver();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			}	
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		// driver.manage().deleteCookieNamed(baseURL);
		
		////.get(baseURL);
		
		//let me add Logger class
		//Logger log=Logger.getLogger("ebanking");
		//PropertyConfigurator.configure("Log4j.properties");
		
	}
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
