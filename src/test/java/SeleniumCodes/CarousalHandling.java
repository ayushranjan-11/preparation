package SeleniumCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CarousalHandling extends BrowserSetup {
	// TODO: This is not resolved yet. Requirement was to fetch name display in the
	// carousal from start to end
	// but only current visible (4) items name are fetched. Need to click arrow
	// button and fetch all items name
	// from carousal

	String baseURL = "https://www.noon.com/uae-en/";

	@Test(priority = 1)
	void BrowserOpenAndNavigation() {
		browserSetupWithChrome(baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(priority = 2)
	void getRecommendedSectionContentList() throws InterruptedException {

		List<WebElement> recommendedSectionContent = new ArrayList<WebElement>();
		String recommendedSectionXpath = "//div[@class='Recommendations_carouselContainer__4cJdQ']"
				+ "//child::div//h2[@class='ProductDetailsSection_title__JorAV']";

		String recommendedSectionHeaderXpath = "//h2[normalize-space(text())='Recommended for you']";
		String nextCTAXpath = "//button[@class='EmblaCarouselArrowButtons_emblaButton__9Tg2v EmblaCarouselArrowButtons_emblaNext__nSJam embla__button embla__button--next'][1]";

		Thread.sleep(2000);
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(recommendedSectionHeaderXpath)));
		// webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(recommendedSectionXpath)));
		action.scrollToElement(driver.findElement(By.xpath(recommendedSectionHeaderXpath))).perform();
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
//				driver.findElement(By.xpath(recommendedSectionXpath)));

		// recommendedSectionContent =
		// driver.findElements(By.xpath(recommendedSectionXpath));
		WebElement nextCTA = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nextCTAXpath)));
		int recommendedProductsNo = driver.findElements(By.xpath(recommendedSectionXpath)).size();
		// recommendedSectionContent =
		// driver.findElements(By.xpath(recommendedSectionXpath));

		for (int i = 0; i < recommendedProductsNo; i++) {
			String singleRecommendationContent = recommendedSectionXpath;
			recommendedSectionContent.add(driver.findElement(By.xpath(singleRecommendationContent)));
			System.out.println(recommendedSectionContent.get(i).getText());

//		while (nextCTA.isDisplayed()) {
//			int recommendedProductsNo = driver.findElements(By.xpath(recommendedSectionXpath)).size();
//			System.out.println("Recommended products no: " + recommendedProductsNo);
//
//			Thread.sleep(2000);
//			nextCTA.click();
//		
//		recommendedSectionContent.addAll(driver.findElements(By.xpath(recommendedSectionXpath)));

//		for (int j = 0; j < recommendedSectionContent.size(); j++) {
//			System.out.println(recommendedSectionContent.get(j).getText());
//		}
		}
	}

	@Test(priority = 2, enabled = false)
	void getRecommendedContent() {
		WebElement header = webDriverWait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Recommended for you']")));
		action.scrollToElement(header).perform();

		WebElement carousel = driver.findElement(By.cssSelector("div.Recommendations_carouselContainer__4cJdQ"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		List<String> productNames = new ArrayList<>();

		while (true) {
			// 1. Grab visible titles
			List<WebElement> titles = carousel
					.findElements(By.cssSelector("h2.ProductDetailsSection_title__JorAV[data-qa='product-name']"));
			if (titles.isEmpty())
				break;
			String firstName = titles.get(0).getText().trim();

			// 2. Collect names, deduping
			for (WebElement t : titles) {
				String name = t.getText().trim();
				if (!name.isEmpty() && !productNames.contains(name)) {
					productNames.add(name);
				}
			}

			// 3. Re-find next-arrow and break if disabled
			WebElement nextBtn = carousel.findElement(By.cssSelector("button.embla__button--next"));
			if (!nextBtn.isEnabled() || nextBtn.getAttribute("class").contains("embla__button--disabled")) {
				break;
			}

			// 4. Click and wait until the **text** of the first item changes
			nextBtn.click();
			wait.until(d -> {
				List<WebElement> after = carousel
						.findElements(By.cssSelector("h2.ProductDetailsSection_title__JorAV[data-qa='product-name']"));
				return !after.isEmpty() && !after.get(0).getText().trim().equals(firstName);
			});
		}

		// Print results
		System.out.println("All recommended products:");
		productNames.forEach(System.out::println);
	}
}
