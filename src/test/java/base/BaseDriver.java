package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {

	WebDriver driver;
	
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void closeBrowser() {
		if(this.driver!= null) {
			driver.quit();
		}
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
}
