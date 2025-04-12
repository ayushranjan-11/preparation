package SeleniumCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionClassLearning {
    static WebDriver driver = new ChromeDriver();
    static ActionClassLearning actionClassLearning = new ActionClassLearning();
    WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    Actions actions = new Actions(driver);

    public static void main(String[] args) throws InterruptedException {
        String url = "https://google.com/";

        actionClassLearning.pageVisit(url);
        String textInputSearchField = "#APjFqb";
        String suggestionList = "//div[@aria-label='google translate']";

        actionClassLearning.mouseHoverAction(textInputSearchField, suggestionList);
    }

    public void pageVisit(String visitURL) {
        driver.get(visitURL);
        driver.manage().window().maximize();
    }

//    public void actionClassUse(WebElement element) {
//        actions.click(element).perform();
//    }

    public void mouseHoverAction(String inputFieldTextXpath, String firstResultXpath) throws InterruptedException {

        WebElement inputField = driver.findElement(By.cssSelector(inputFieldTextXpath));
        actions.sendKeys(inputField, "google").build().perform();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstResultXpath)));
        WebElement suggestionSelect = driver.findElement(By.xpath(firstResultXpath));

        actions.moveToElement(suggestionSelect).build().perform();

        driverWait.until(ExpectedConditions.elementToBeClickable(suggestionSelect));
//
        actions.click(suggestionSelect).build().perform();
    }
}
