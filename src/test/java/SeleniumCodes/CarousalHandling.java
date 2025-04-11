package SeleniumCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CarousalHandling extends BrowserSetup {
    //TODO: This is not resolved yet. Requirement was to fetch name display in the carousal from start to end
    // but only current visible (4) items name are fetched. Need to click arrow button and fetch all items name
    // from carousal


    static WebDriver driver = new ChromeDriver();
    static String baseURL = "https://www.noon.com/uae-en/";


    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.get(baseURL);

        CarousalHandling carousalHandling = new CarousalHandling();
        carousalHandling.getRecommendedSectionXpath();
    }

    public void getRecommendedSectionXpath() {
        String recommendedSectionXpath = "//div[@class='Recommendations_itemContainer__9pCOx']"
                + "//child::div//h2[@class='ProductDetailsSection_title__JorAV']";

        String recommendedSectionHeaderXpath = "//h2[normalize-space(text())='Recommended for you']";

        WebElement scrollIntoView = driver.findElement(By.xpath(recommendedSectionHeaderXpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollIntoView);

        int recommendedProductsNo = driver.findElements(By.xpath(recommendedSectionXpath)).size();
        System.out.println("Recommended products no: " + recommendedProductsNo);
        for (int i = 0; i < recommendedProductsNo; i++) {
            List<WebElement> recommendedSectionContent = driver.findElements(By.xpath(recommendedSectionXpath));
            System.out.println(recommendedSectionContent.get(i).getText());
        }
    }
}
