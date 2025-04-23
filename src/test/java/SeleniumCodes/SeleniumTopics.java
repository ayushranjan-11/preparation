package SeleniumCodes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

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
	}

	@Override
	public void browserSetupWithFirefox(String baseURL) {
		driver = new FirefoxDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
//		driver.quit();
	}

	void provideInputToTheFields() {
		adminInputField = driver.findElement(By.name("username"));
		System.out.println(adminInputField.getDomProperty("name"));
		JavascriptExecutor javaScript = (JavascriptExecutor) driver;
		javaScript.executeScript("arguments[0].value= 'Admin'", adminInputField);

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
}
