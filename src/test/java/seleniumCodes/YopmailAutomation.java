package seleniumCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YopmailAutomation {

    WebDriver driver = new ChromeDriver();


    @Test(priority = 1)
    void gettingOTP() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.yopmail.com");

        //int receivedOTP = navigateToThePage();
        //System.out.println("Received OTP from method: "+receivedOTP);
    }

    public int navigateToThePage() throws InterruptedException {
        int otpInInt = 0;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("#login")).sendKeys("assignment@yopmail.com");
        driver.findElement(By.xpath("//button[@class='md']")).click();
        Thread.sleep(2000);
        driver.switchTo().frame("ifinbox");
        driver.findElement(By.xpath("//span[text()='Agoda'][1]")).click();
        driver.switchTo().parentFrame();
        driver.switchTo().frame("ifmail");

       String OTPMessage =  driver.findElement(By.xpath("//td[@style='font-size: 14px; height: 50px; vertical-align: middle']")).getText();
        System.out.println(OTPMessage);
        Pattern pattern = Pattern.compile("\\d{6}"); // Matches one or more digits
        Matcher matcher = pattern.matcher(OTPMessage);

        if(matcher.find()){
            String OTP = matcher.group();
            otpInInt = Integer.parseInt(OTP);
            System.out.println(OTP);
        } else System.out.println("Unable to grab OTP");

        return otpInInt;
    }

}
