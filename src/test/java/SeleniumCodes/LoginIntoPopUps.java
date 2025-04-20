package SeleniumCodes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginIntoPopUps {
    //Demonstration for login when pop up is shown
    String baseURL = "https://the-internet.herokuapp.com/";
    String authURL = "https://the-internet.herokuapp.com/basic_auth";
    String popUpUsernameAndPassword = "admin:admin@";
    WebDriver driver = new ChromeDriver();

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

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < urls.length; i++) {
            stringBuffer.append(urls[i]);
        }

        driver.get(stringBuffer.toString());

    }

//    void popUpValueEntryWithSendKeys(){
//        driver.switchTo().alert().sendKeys("admin");
//
//    }
}
