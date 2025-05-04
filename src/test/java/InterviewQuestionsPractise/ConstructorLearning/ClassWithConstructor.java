package InterviewQuestionsPractise.ConstructorLearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ClassWithConstructor {
	WebDriver driver;
	String browserName;

	public ClassWithConstructor(String browserName) {
		this.browserName = browserName;
		BrowserOpen();
	}

	void BrowserOpen() {
		browserName.toLowerCase();

		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		case "edge":
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		default: {
			System.out.println("Please provide option as chrome, firefox, edge");
		}
		}

	}
}
