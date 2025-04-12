package SeleniumCodes;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class ClassWithWebDriver {
    ChromeDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {
        String visitURL = "https://www.gamp.gg/";
        ClassWithWebDriver classWithWebDriver = new ClassWithWebDriver();
        classWithWebDriver.pageVisit(visitURL);
        classWithWebDriver.takeScreenshotAsFull();
        classWithWebDriver.takeScreenshotAsPortion();
        classWithWebDriver.takeScreenshotOfWebElement();

        //closing the driver
        classWithWebDriver.driverQuit();
    }

    public void pageVisit(String visitURL) {
        driver.get(visitURL);
        driver.manage().window().maximize();
    }

    public void takeScreenshotAsFull() {

        try {
            TakesScreenshot takesScreenshot = driver;

            File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("src/test/Screenshots/screenshotFromDifferentClass.png");

            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void takeScreenshotAsPortion() {
        //Just to specify the portion or section with web element and proceed further as same

        WebElement webElement = driver.findElement(By.xpath("//p[normalize-space()='WELCOME TO GAMP']"));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='WELCOME TO GAMP']")));

        try {
            File sourceFile = webElement.getScreenshotAs(OutputType.FILE); //specify element directly for the source file
            File destinationFile = new File("src/test/Screenshots/screenshotFromDifferentClassOfPortion.png");

            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void takeScreenshotOfWebElement() {

        //Taking screenshot of the logo present in the page
        WebElement webElement = driver.findElement(By.xpath("//img[@alt='gamp-logo']"));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='WELCOME TO GAMP']")));

        try {
            File sourceFile = webElement.getScreenshotAs(OutputType.FILE); //specify element directly for the source file
            File destinationFile = new File("src/test/Screenshots/screenshotOfWebElement.png");

            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void driverQuit() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(1000);
            driver.quit();
        }
    }
}
