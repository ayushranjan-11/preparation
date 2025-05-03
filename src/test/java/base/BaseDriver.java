package base;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseDriver {

	public WebDriver driver;
	public WebDriverWait wait;
	public String filePath = System.getProperty("user.dir") + "/src/test/resources/pomAndpageFactory.properties";
	// public File file = new
	// File("/preparation/src/test/resources/pomAndpageFactory.properties");
	public Properties properties = new Properties();

	public void setup() throws FileNotFoundException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	public void closeBrowser() {
		if (this.driver != null) {
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		return this.driver;
	}
}
