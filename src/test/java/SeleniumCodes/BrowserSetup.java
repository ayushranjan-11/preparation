package SeleniumCodes;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetup {
	WebDriver driver;

	public void browserSetupWithChrome(String baseURL) {
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
	}

	public void browserSetupWithFirefox(String baseURL) {
		driver = new FirefoxDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
	}

	public void browserQuit() {

		if (driver != null) {
			Set<String> windowHandlesOpenCount = driver.getWindowHandles();
			if (windowHandlesOpenCount.size() < 2) {
				driver.close();
			} else {
				driver.quit();
			}
		}
	}
}
