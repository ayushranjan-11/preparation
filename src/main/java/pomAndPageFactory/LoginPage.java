package pomAndPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//OrangeHRM is the website used for understanding POM and Page Factory
//Link: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
public class LoginPage {
	public WebDriver webDriver;

	LoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(xpath = "//input[@name = 'username']")
	WebElement username;

	@FindBy(xpath = "//input[@name = 'password']")
	WebElement password;

	@FindBy(tagName = "button")
	WebElement loginCTA;

	@FindBy(xpath = "//p[text()[normalize-space() = 'Forgot your password?']]")
	WebElement forgotPasswordLinkText;

	public WebElement getForgotPasswordLinkText() {
		return forgotPasswordLinkText;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

}
