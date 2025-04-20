package SeleniumCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.devtools.v132.page.model.Screenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class WorldPopulationNumber extends BrowserSetup {
    //    WebDriver driver = new ChromeDriver();
    static BrowserSetup browserSetup = new BrowserSetup();
    static String baseUrl = "https://www.worldometers.info/world-population/";

    public static void main(String[] args) {
        //BrowserSetup browserSetup = new BrowserSetup();
        browserSetup.browserSetupWithChrome(baseUrl);

        WorldPopulationNumber worldPopulationNumber = new WorldPopulationNumber();
        //worldPopulationNumber.browserLaunch(baseUrl);
        //       worldPopulationNumber.getCountingFromWebPage();

        String currentWorldPopulationXpath = "//div[@class='font-bold text-4xl md:text-6xl text-center text-zinc-500']" +
                "/span[@class='rts-counter']";
        String combinedXpathForTodayAndThisYear = "//div[normalize-space(text())='Today' or normalize-space(text())='This Year']" +
                "//parent::div//span[@class='rts-counter text-2xl font-bold']";

        int x = 1;
        while (x < 20) {
            System.out.println("Current world population");
            worldPopulationNumber.improvedVersionFromNaveenTutorials(currentWorldPopulationXpath);
            System.out.println("Today and this year population");
            worldPopulationNumber.improvedVersionFromNaveenTutorials(combinedXpathForTodayAndThisYear);
            x++;
        }


    }

//    public void browserLaunch(String baseUrl) {
//        driver.get(baseUrl);
//        //driver.manage().window().maximize();
//    }

    public void getCountingFromWebPage() {
        String worldPopulationCssSelector = "div.font-bold > span:nth-child(1)";
        String worldPopulationXPath = "//div[@class='font-bold text-4xl md:text-6xl text-center text-zinc-500']/span[@class='rts-counter']";
        String birthTodayCssSelector = "div.grid:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(2)";
        String deathTodayCssSelector = "div.grid:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > span:nth-child(2)";
        String populationGrowthTodayCssSelector = "div.grid:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > span:nth-child(2)";

        String birthThisYear = "div.grid:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > span:nth-child(2)";
        String deathThisYear = "div.grid:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > span:nth-child(2)";
        String populationGrowthThisYear = "div.grid:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > span:nth-child(2)";

        ArrayList<String> cssSelectors = new ArrayList<>();
        cssSelectors.add(worldPopulationCssSelector);
        cssSelectors.add(birthTodayCssSelector);
        cssSelectors.add(deathTodayCssSelector);
        cssSelectors.add(populationGrowthTodayCssSelector);
        cssSelectors.add(birthThisYear);
        cssSelectors.add(deathThisYear);
        cssSelectors.add(populationGrowthThisYear);
        int x = 20;

        while (x > 0) {

            for (String cssSelector : cssSelectors) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                String currentText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector))).getText();
                System.out.println(currentText);
            }
            x--;

        }

    }

    public void improvedVersionFromNaveenTutorials(String xpathForElement){
        List<WebElement> elementsList = browserSetup.driver.findElements(By.xpath(xpathForElement));
        for (WebElement element : elementsList) {
            System.out.println(element.getText());
        }

        //Taking screenshot functionality
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) browserSetup.driver;
            File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

            File destinationFile = new File("src/test/Screenshots/screenshot.png");
            FileUtils.copyFile(sourceFile, destinationFile);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        finally {
//            browserSetup.driver.quit();
//        }
    }
}
