package SeleniumCodes;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class LoginIntoPopUps {
    //Demonstration for login when pop up is shown
    String baseURL = "https://the-internet.herokuapp.com/";
    String authURL = "https://the-internet.herokuapp.com/basic_auth";
    String popUpUsernameAndPassword = "admin:admin@";
    WebDriver driver = new ChromeDriver();
    Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

    public static void main(String[] args) {
        LoginIntoPopUps loginIntoPopUps = new LoginIntoPopUps();
        loginIntoPopUps.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginIntoPopUps.browserOpenAndNavigate();
        loginIntoPopUps.optionSelectAndPopUpOpen();
        loginIntoPopUps.popUpValueEntry();

        //loginIntoPopUps.popUpValueEntryWithSendKeys();
    }


    void browserOpenAndNavigate() {
        driver.get(baseURL);
    }

    void optionSelectAndPopUpOpen() {
        String optionXpath = "//a[normalize-space()='Basic Auth']";
        driver.findElement(By.xpath(optionXpath)).click();
    }

    void popUpValueEntry() {

        //This will be adding username and password in the url as append
        String[] urls = driver.getCurrentUrl().split("//");
        urls[0] += "//";
        urls[1] = popUpUsernameAndPassword + urls[1];

        StringBuilder stringBuilder = new StringBuilder();
        for (String url : urls) {
            stringBuilder.append(url);
        }

        driver.get(stringBuilder.toString());

    }

//    void popUpValueEntryWithSendKeys(){
//        driver.switchTo().alert().sendKeys("admin");
//
//    }
}
