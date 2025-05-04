package seleniumCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinks {
    static WebDriver driver = new ChromeDriver();
    static String baseURL = "https://www.flipkart.com/";

    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.get(baseURL);
        getLinks();
    }

    public static void getLinks() {

        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        System.out.println(linkList.size());

        List<String> urlList = new ArrayList<>();

        for (WebElement link : linkList) {
            //System.out.println(link.getDomAttribute("href"));
            String linkHref = link.getDomProperty("href");
            urlList.add(linkHref);
            //linkVisit(linkHref);


            urlList.parallelStream().forEach(linkList1 -> linkVisit(linkHref));

        }
    }

    public static void linkVisit(String linkURL) {
        try {
            URI url = new URI(linkURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.toURL().openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() >= 400) {
                System.out.println(linkURL+ " Link is broken as response code is " + httpURLConnection.getResponseCode());
            } else {
                System.out.println(linkURL+ " Link is working as response code is " + httpURLConnection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
