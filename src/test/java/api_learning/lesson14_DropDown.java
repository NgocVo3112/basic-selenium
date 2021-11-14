package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class lesson14_DropDown implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Navigate to Hovers page
            driver.get(baseURL.concat(dropdownPage));

            // Target Dropdown
            Select select = new Select(driver.findElement(By.id("dropdown")));

            select.selectByVisibleText("Option 1");
            Thread.sleep(1000);

            select.selectByIndex(2);
            Thread.sleep(1000);

            select.selectByValue("1");
            Thread.sleep(1000);
        } catch (Exception ignored) {
        } finally {
            driver.quit();
        }
    }
}

