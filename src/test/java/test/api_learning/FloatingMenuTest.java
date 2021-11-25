package test.api_learning;

import driver.DriverFactory;
import models.pages.api_learning.FloatingMenuPage;
import org.openqa.selenium.WebDriver;

import static url.Urls.baseURL;
import static url.Urls.floatingPageSlug;

public class FloatingMenuTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(baseURL.concat(floatingPageSlug));
        try{
            FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
            floatingMenuPage.ScrollToBottom();
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}
