package SeleniumCodes;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserSetup {
	WebDriver driver;
	WebDriverWait webDriverWait;
	Actions action;

	public void browserSetupWithChrome(String baseURL) {
		driver = new ChromeDriver();
		action = new Actions(driver);
		driver.get(baseURL);
		driver.manage().window().maximize();
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void browserSetupWithFirefox(String baseURL) {
		driver = new FirefoxDriver();
		action = new Actions(driver);
		driver.get(baseURL);
		driver.manage().window().maximize();
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
