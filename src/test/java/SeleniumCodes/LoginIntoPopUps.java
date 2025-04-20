package SeleniumCodes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginIntoPopUps {
	//Demonstration for login when pop up is shown
	String baseURL = "https://the-internet.herokuapp.com/";
	WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) {
		LoginIntoPopUps loginIntoPopUps = new LoginIntoPopUps();
		loginIntoPopUps.browserOpenAndNavigate();
	}
	
	
	void browserOpenAndNavigate() {
		driver.get(baseURL);
	}
	
	void optionSelectAndPopUpOpen() {
		String optionXpath = "//a[normalize-space()='Basic Auth']";
		driver.findElement(By.xpath(optionXpath)).click();
	}
}
