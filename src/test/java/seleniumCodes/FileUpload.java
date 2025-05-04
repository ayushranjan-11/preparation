package seleniumCodes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import base.BaseDriver;

public class FileUpload extends BaseDriver {
	FileInputStream fileInputStream;

	// File upload with properties files
	@BeforeMethod
	@Override
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	@Test
	void navigateAndImageUpload() throws IOException, InterruptedException {
		fileInputStream = new FileInputStream(filePath);
		properties.load(fileInputStream);

		driver.get(properties.getProperty("urlForInternetHerokuapp"));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("uploadSectionXpath"))))
				.click(); // navigating to the upload section of the page

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(properties.getProperty("fileuploadOptionId"))))
				.sendKeys(System.getProperty("user.dir") + properties.getProperty("sampleImagePath"));

		Thread.sleep(3000);
		driver.findElement(By.id(properties.getProperty("uploadCTAId"))).click();

		// TODO: Add confirmation about the file getting uploaded
		Assert.assertEquals(
				driver.findElement(By.xpath(properties.getProperty("uploadSuccessfulMessageXpath"))).getText(),
				properties.getProperty("uploadFileExpectedMessage"));
		System.out.println("Uploaded file name is: "
				+ driver.findElement(By.id(properties.getProperty("fileUploadedTextId"))).getText());
	}

	@AfterClass
	@Override
	public void closeBrowser() {
		if (this.driver != null) {
			driver.quit();
		}
	}

}
