package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class lession13 implements Urls {
    public static void main(String[] args){
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get(baseURL.concat(dynamic_Controls));
            By poweredByLinkSel = By.linkText("Elemental Selenium");
            WebElement poweredByLinkElm = driver.findElement(poweredByLinkSel);
            System.out.println("Link text :" + poweredByLinkElm.getText());
            System.out.println("Power by Href " + poweredByLinkElm.getAttribute("href"));
            System.out.println("Link text target " + poweredByLinkElm.getAttribute("target"));
            System.out.println("Current URL :  " + driver.getCurrentUrl());
            System.out.println("Current page title :" + driver.getTitle());

            By checkboxExampleBtnSel = By.cssSelector("#checkbox-example button");

            // Click on Remove button
            WebElement removeBtnElm = driver.findElement(checkboxExampleBtnSel);
            removeBtnElm.click();

            // Wait some sec
            WebElement progressBar = driver.findElement(By.cssSelector("#loading"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOf(progressBar));

            // Click on Add button
            WebElement addBtnElm = driver.findElement(checkboxExampleBtnSel);
            addBtnElm.click();
            wait.until(ExpectedConditions.invisibilityOf(progressBar));

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
