package SeleniumCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitsInSelenium {
    //Class is to demonstrate different waits in the selenium
    WebDriver driver = new FirefoxDriver();
    String baseURL = "https://www.gamp.gg";
    String className = "ayush";
    String newTabURl = "https://www.linkedin.com/in/ayush-ranjan-724011201/";

    //Calling WebDriverWait class for explicit waits
    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public static void main(String[] args) {
        WaitsInSelenium waitsInSelenium = new WaitsInSelenium();
        // Implicit wait is a universal wait for all the elements in the page
        waitsInSelenium.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        waitsInSelenium.BrowserOpenAndURLNavigation();
        waitsInSelenium.ExplicitWaitInSelenium();
//        waitsInSelenium.FluentWaitInSelenium();
        waitsInSelenium.BrowserQuit();
    }

    void BrowserOpenAndURLNavigation() {
        driver.get(baseURL);
        driver.manage().window().maximize();
    }

    void ExplicitWaitInSelenium() {
        //ExplicitWait is not a universal wait, it is used for specific element/s with a specific condition
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className))).click();
    }

    void FluentWaitInSelenium() {
        //Fluent wait can give the option to retry for condition as per defined time
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500)).withMessage("Element was found successfully").ignoring(Exception.class);

        fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                WebElement element = driver.findElement(By.className("className"));
                if (element != null & element.isDisplayed()) {
                    System.out.println("Sucess");
                    return element;
                } else {
                    System.out.println("Unable to find element");
                    return null;
                }
            }
        });
    }

    void BrowserQuit() {
        if (driver != null) {
            Object[] openedWindowHandles = driver.getWindowHandles().toArray();

            if (openedWindowHandles.length > 1) {
                System.out.println("Total tab opened: " + openedWindowHandles.length);
                driver.switchTo().window(openedWindowHandles[1].toString());
                ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                webDriverWait.until(pageLoadCondition);
                driver.close(); // will close the current tab of the browser and if more than 1 then it will return back to the previous tab
            }
            driver.quit();
        } else System.out.println("Driver is null");
    }
}
