package seleniumCodes;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import base.BaseDriver;

//Download file from browser with single click and saving the file on project itself
public class FileDownload {
	String downloadSectionURL = "https://the-internet.herokuapp.com/download";
	ChromeOptions chromeOptions = new ChromeOptions();
	// String downloadPath = System.getProperty("user.dir") +
	// "\\src\\test\\resources\\downloadedItems";
	// Preferred: NIO API for making path OS independent
	Path downloadDir = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "downloadedItems");

	String downloadPath = downloadDir.toString();

	// BaseDriver baseDriver;
	ChromeDriver driver;
	WebDriverWait wait;

	@Test(priority = 1)
	void settingCustomDownloadLocation() {
		// Initializing download path from default to folder specific in project
		Map<String, Object> preference = new HashMap<>();
		preference.put("download.default_directory", downloadPath);
		preference.put("download.prompt_for_download", false);
		preference.put("download.directory_upgrade", true);
		preference.put("downloadPath", downloadPath);
		// preference.put("safebrowsing.enabled", true);
		chromeOptions.setExperimentalOption("prefs", preference);
		// driver = new ChromeDriver(chromeOptions);

		driver = new ChromeDriver(chromeOptions);

		// This need to be explained as it is for chrome version 133+
		Map<String, Object> cdpParams = new HashMap<>();
		cdpParams.put("behavior", "allow");
		cdpParams.put("downloadPath", downloadPath);
		driver.executeCdpCommand("Page.setDownloadBehavior", cdpParams);

		// driver.executeCdpCommand("Page.setDownloadBehavior", preference);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@Test(priority = 2, dependsOnMethods = "settingCustomDownloadLocation")
	void initateDownload() {
		driver.get(downloadSectionURL);
		driver.manage().window().maximize();
		// Navigate to the link and click the linkText to initiate the download into
		// default download folder
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("image.jpg"))).click();

		// TODO: make download folder specific in the project folder and add wait
		// regarding the download time of the file because browser is closing without
		// letting download to be completed

		String fileName = "image.jpg"; // This should be dynamic

		File file = new File(downloadPath, fileName);

		FluentWait<File> fluentWait = new FluentWait<File>(file).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);

		boolean isDownloadComplete = fluentWait.until(f -> f.exists() && f.canRead());

		if (isDownloadComplete) {
			System.out.println("File is completely downloaded");
		} else
			System.out.println("File is still not downloaded");
	}

	@AfterClass
	public void closeBrowser() {
		if (this.driver != null) {
			driver.quit();
		}
	}

}
