package seleniumCodes;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsCloud {

	static ChromeOptions browserOptions = new ChromeOptions();

	public static void main(String[] args) throws MalformedURLException, URISyntaxException {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("latest");
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("username", "oauth-ayushdx98-3a475");
		sauceOptions.put("accessKey", "be03eee0-1df9-4b37-aa2e-0de8962ee807");
		sauceOptions.put("build", "selenium-build-6ZDB4");
		sauceOptions.put("name", "LearningCloudRun");
		browserOptions.setCapability("sauce:options", sauceOptions);

		// start the session
		// URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
		// start the session
		URI url = new URI("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url.toURL(), browserOptions);

		// run commands and assertions
		driver.get("https://saucedemo.com");
		String title = driver.getTitle();
		boolean titleIsCorrect = title.contains("Swag Labs");
		String jobStatus = titleIsCorrect ? "passed" : "failed";

		// end the session
		driver.executeScript("sauce:job-result=" + jobStatus);
		driver.quit();
	}

}
