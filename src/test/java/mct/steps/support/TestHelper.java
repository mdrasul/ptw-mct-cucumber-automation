package mct.steps.support;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHelper {

	
	WebDriver driver;	

	public WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		// A global Wait for Element 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}
	
	public void launchApplication() {
		driver.get("https://www.demo.iscripts.com/multicart/demo/index.php");
	}

}
