package seleniumCodes;

import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTopics extends BrowserSetup {
	// String baseURL =
	// "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	String baseURL = "https://blazedemo.com/";
	static SeleniumTopics inputWithoutSendKeys = new SeleniumTopics();
	WebElement adminInputField;

	public static void main(String[] args) {

		inputWithoutSendKeys.browserSetupWithFirefox(inputWithoutSendKeys.baseURL);
		inputWithoutSendKeys.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// inputWithoutSendKeys.provideInputToTheFields();
		inputWithoutSendKeys.EnterKeyPress();
		inputWithoutSendKeys.navigationPostUrlVisit();
		// inputWithoutSendKeys.getCookies();
		inputWithoutSendKeys.browserQuit();

	}

	@Override
	public void browserSetupWithFirefox(String baseURL) {
		driver = new FirefoxDriver();
		driver.navigate().to(baseURL);
		driver.manage().window().maximize();
//		driver.quit();
	}

	void provideInputToTheFields() {
		adminInputField = driver.findElement(By.name("username"));
		System.out.println(adminInputField.getDomProperty("name"));
		JavascriptExecutor javaScript = (JavascriptExecutor) driver;
		javaScript.executeScript("arguments[0].value= 'Admin'", adminInputField);
		javaScript.executeScript("window.location.reload();");

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		}
		adminInputField.clear();
	}

	void EnterKeyPress() {
		synchronized (driver) {
			try {
				driver.wait(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.findElement(By.xpath("//input[@class = 'btn btn-primary']")).sendKeys(Keys.ENTER);

	}

	void navigationPostUrlVisit() {
		// Back was not working because it was getting executed before the page was
		// getting navigated, that's why this wait is initiated.
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("reserve.php"));
		driver.navigate().back();
	}

//	void getCookies() {
//		Set<Cookie> cookies = new HashSet<Cookie>();
//		System.out.println(cookies.toString());
//
//	}

	@Override
	public void browserQuit() {

		if (driver != null) {
			Set<String> windowHandlesOpenCount = driver.getWindowHandles();
			Iterator<String> windowHandleIterate = windowHandlesOpenCount.iterator();
			if (windowHandlesOpenCount.size() > 2) {
				driver.switchTo().window(windowHandleIterate.next());
				driver.manage().deleteAllCookies();
				driver.navigate().refresh();
				driver.close();
			} else {
				driver.quit();
			}
		}
	}

}
