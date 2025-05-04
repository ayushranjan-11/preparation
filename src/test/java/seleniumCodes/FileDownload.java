package seleniumCodes;
import base.BaseDriver;

//Download file from browser with single click and saving the file on project itself
public class FileDownload extends BaseDriver {
	String downloadSectionURL = "https://the-internet.herokuapp.com/download";

	// Download can be initiated on click or visit to the link
//	@BeforeMethod
//	@Override
//	public void setup() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	}
	
	void initateDownload() {
		driver.get(downloadSectionURL);
	}

}
