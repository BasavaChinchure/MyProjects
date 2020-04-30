package hybrid.HybridFrame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestBase {
	@Test
	public void run() {
		System.out.println("Hello");
		System.setProperty("webdriver.chrome.driver","D:\\NewJavaPractice\\HybridFrame\\Driver\\chromedriver.exe");
		 
		 WebDriver driver=new ChromeDriver();
		  
		 driver.manage().window().maximize();
		 driver.get("http://demo.guru99.com/v4/index.php");
		
	}

}
