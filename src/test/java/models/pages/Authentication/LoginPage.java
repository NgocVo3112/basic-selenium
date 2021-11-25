package models.pages.Authentication;

import models.components.global.FooterComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private static final By usernameSel = By.id("username");
    private static final By passwordSel = By.id("password");
    private static final By loginBtnSel = By.cssSelector("button[type='submit']");
    private FooterComponent footerComp;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage inputUsername (String usernameStr){
        driver.findElement(usernameSel).sendKeys(usernameStr);
        return this;
    }

    public LoginPage inputPassword (String passwordStr){
        driver.findElement(passwordSel).sendKeys(passwordStr);
        return this;
    }

    public LoginPage clickOnLoginBtn() {
        driver.findElement(loginBtnSel).click();
        return this;
    }
    public FooterComponent footerComp(){
        return new FooterComponent(driver);
    }
}
