package pomAndPageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import base.BaseDriver;

public class LoginPagePageFactory extends BaseDriver {
	FileInputStream fileInputStream;
	LoginPage loginPage;

//	@BeforeMethod
//	@Override
//	public void setup() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		try {
//			fileInputStream = new FileInputStream(filePath);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@Test(priority = 0)
	public void FileInputStreamSetup() {
		try {
			fileInputStream = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void loginProcess() throws IOException {
		properties.load(fileInputStream); // To load the file and get the data from the files

		driver.get(properties.getProperty("url"));
		loginPage = new LoginPage(driver);
		wait.until(ExpectedConditions.visibilityOf(loginPage.username)); // This is also a way to interact with in wait,
																			// because waits can be used for other
																			// conditions than only elements
		loginPage.username.sendKeys(properties.getProperty("username"));
		loginPage.password.sendKeys(properties.getProperty("password"));
		loginPage.loginCTA.click();
	}

	@AfterClass
	@Override
	public void closeBrowser() {
		if (this.driver != null) {
			driver.quit();
		}
	}
}
