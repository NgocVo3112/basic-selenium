package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FromHanding implements Urls{
    private static final By usernameSel = By.id("username");
    private static final By passwordSel = By.cssSelector("#password");
    private static final By loginBtnSel = By.cssSelector("[type='submit']");

    public static void main(String[] args) {
        String usernameStr = "tomsmith";
        String passwordStr = "SuperSecretPassword!";
        WebDriver driver = DriverFactory.getChromeDriver();
        String loginURL = baseURL.concat(loginSlug);
        driver.get(loginURL);
        try{
           login(driver,usernameStr,passwordStr);
        }catch (Exception ignored){
        } finally {
            driver.quit();
       }
    }
    private static void login (WebDriver driver, String username, String password){
        WebElement usernameElem = driver.findElement(usernameSel);
        WebElement passwordElem = driver.findElement(passwordSel);
        WebElement loginBtnElem = driver.findElement(loginBtnSel);
        usernameElem.sendKeys(username);
        passwordElem.sendKeys(password);
        loginBtnElem.click();
    }

}
