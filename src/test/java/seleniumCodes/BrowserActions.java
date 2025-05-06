package seleniumCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;

import base.BaseDriver;

public class BrowserActions {
	static Dimension dimension = new Dimension(320, 600);
	static BaseDriver baseDriver = new BaseDriver();
	static Actions actions = new Actions(baseDriver.driver);
	// Browser resize with custom dimension

	public static void main(String[] args) {
		String urlForRightAndDoubleClick = "https://www.google.co.in";
		String urlForDragAndDrop = "https://the-internet.herokuapp.com/drag_and_drop";
		/*
		 * This opens the browser window in full size and then resizes this because full
		 * size is set on BaseDriver constructor
		 */
		baseDriver.resizeBrowser(dimension);

		rightClickAction(urlForRightAndDoubleClick);
		doubleClick(urlForRightAndDoubleClick);
		dragAndDrop(urlForDragAndDrop);
	}

	public static void rightClickAction(String url) {
		baseDriver.driver.get(url);
		actions.contextClick(
				baseDriver.driver.findElement(By.xpath("//a[@class = 'MV3Tnb' and normalize-space(text()) = 'Store']")))
				.build().perform();
	}

	public static void doubleClick(String url) {
		baseDriver.driver.get(url);
		actions.doubleClick(baseDriver.driver.findElement(By.xpath("//div[@class = 'iblpc']"))).build().perform();
	}

	public static void dragAndDrop(String url) {
		baseDriver.driver.get(url);
		actions.dragAndDrop(baseDriver.driver.findElement(By.id("column-a")),
				baseDriver.driver.findElement(By.id("column-b"))).build().perform();
	}

}
