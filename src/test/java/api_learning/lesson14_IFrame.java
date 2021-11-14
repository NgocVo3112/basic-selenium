package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class lesson14_IFrame implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {

            driver.get(baseURL.concat(iframesPage));

            // Switch to iFrame
            driver.switchTo().frame(driver.findElement(By.cssSelector("[id$='ifr']")));

            // Clear default text then input the new ones
            WebElement editorInputElem = driver.findElement(By.id("tinymce"));
            editorInputElem.clear();
            editorInputElem.sendKeys("This is test ......");

            Thread.sleep(2000);

            // Switch back to default frame
            driver.switchTo().defaultContent();

        } catch (Exception ignored) {
        } finally {
            driver.quit();
        }
    }
}

