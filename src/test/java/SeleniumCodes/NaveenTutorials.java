package SeleniumCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class NaveenTutorials {
    WebDriver driver = new ChromeDriver();
    String baseUrl = "https://www.worldometers.info/world-population/";

    public static void main(String[] args) {
        NaveenTutorials naveenTutorials = new NaveenTutorials();
        naveenTutorials.browserLaunch();
        naveenTutorials.getCountingFromWebPage();
    }

    public void browserLaunch() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    public void getCountingFromWebPage() {
        String worldPopulationCssSelector = "div.font-bold > span:nth-child(1)";
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
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                String currentText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector))).getText();
                System.out.println(currentText);
            }
            x--;

        }

    }
}
