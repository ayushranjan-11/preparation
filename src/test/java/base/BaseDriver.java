package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class BaseDriver {

	public WebDriver driver;
	public WebDriverWait wait;
	public String filePath = System.getProperty("user.dir") + "/src/test/resources/pomAndpageFactory.properties";
	// public File file = new
	// File("/preparation/src/test/resources/pomAndpageFactory.properties");
	public Properties properties = new Properties();

	public BaseDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public BaseDriver(ChromeOptions chromeOptions) {
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void resizeBrowser(Dimension dimension) {
		driver.manage().window().setSize(dimension);
	}

	// 1. Moving the setup method on constructor, so that calling it again and again
	// in each subclass can be eliminated
	// 2. Adding @BeforeMethod with setup method can achieve the same, if want to
	// use testNG
//	@BeforeMethod
//	public void setup() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	}

	@AfterClass
	public void closeBrowser() {
		if (this.driver != null) {
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		return this.driver;
	}
}
