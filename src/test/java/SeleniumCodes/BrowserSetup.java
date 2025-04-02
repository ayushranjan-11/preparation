package SeleniumCodes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetup {
    WebDriver driver = null;


    public void browserSetupWithChrome(String baseURL) {
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    public void browserSetupWithFirefox() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
}
