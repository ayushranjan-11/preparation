package seleniumCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.BaseDriver;

//Download file from browser with single click and saving the file on project itself
public class FileDownload extends BaseDriver {
	String downloadSectionURL = "https://the-internet.herokuapp.com/download";

	// Download can be initiated on click or visit to the link

	@Test
	void initateDownload() {
		driver.get(downloadSectionURL);

		// Navigate to the link and click the linkText to initiate the download into
		// default download folder
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("photo.jpg"))).click();

		// TODO: make download folder specific in the project folder and add wait
		// regarding the download time of the file because browser is closing without letting download to be completed
	}

}
