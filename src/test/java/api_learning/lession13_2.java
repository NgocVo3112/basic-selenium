package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class lession13_2 implements Urls {
    private static final By inputFieldSel = By.cssSelector("input");
    private static final By btnSel = By.cssSelector("button");
    public static void main(String[] args){
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get(baseURL.concat(dynamic_Controls));

            // 1st FORM | Input example form
            By checkBoxExampleFormSel = By.cssSelector("#checkbox-example");
            WebElement checkBoxExampleFormElem = driver.findElement(checkBoxExampleFormSel);
            WebElement checkBoxOptionElem = checkBoxExampleFormElem.findElement(inputFieldSel);
            WebElement removeBtnElm = checkBoxExampleFormElem.findElement(btnSel);

            if(!checkBoxOptionElem.isSelected())
                checkBoxOptionElem.click();
            removeBtnElm.click();
            WebElement progressBar = driver.findElement(By.cssSelector("#loading"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOf(progressBar));
            removeBtnElm.click();
            wait.until(ExpectedConditions.invisibilityOf(progressBar));
            WebElement checkboxID = driver.findElement(By.xpath("//input[@id='checkbox']"));
            checkboxID.click();

            // 2nd FORM | Input example form
            By inputExampleFormSel = By.cssSelector("#input-example");
            WebElement inputExampleFormElm = driver.findElement(inputExampleFormSel);
            WebElement inputExampleInOutFieldElm = inputExampleFormElm.findElement(inputFieldSel);
            WebElement inputExampleBtnElm = inputExampleFormElm.findElement(btnSel);

            if(!inputExampleInOutFieldElm.isEnabled())
                inputExampleBtnElm.click();
            WebElement enalbleLinkText = driver.findElement(By.xpath("//form[@id='input-example']/p"));
            wait.until(ExpectedConditions.visibilityOf(enalbleLinkText));
            if(enalbleLinkText.isDisplayed()) {
                inputExampleInOutFieldElm.sendKeys("Test here");
                inputExampleBtnElm.click();
            }

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
