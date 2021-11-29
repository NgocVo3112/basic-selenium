package test.authentication;

import driver.DriverFactory;
import models.pages.Authentication.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static url.Urls.baseURL;
import static url.Urls.loginSlug;

public class LoginTest {
    @Test
    public void loginWithCorrectCreds() {
        String usernameStr = "tomsmith";
        String passwordStr = "SuperSecretPassword!";
        WebDriver driver = DriverFactory.getChromeDriver();

        String loginURL = baseURL.concat(loginSlug);
        driver.get(loginURL);

        try{
            LoginPage loginPage = new LoginPage(driver);
            loginPage
                    .inputUsername(usernameStr)
                    .inputPassword(passwordStr)
                    .clickOnLoginBtn();
            String actualFooterComp = loginPage.footerComp().FooterText();
            String expectedFooterComp = "Powered by Elemental Selenium";

            String actualFooterLink = loginPage.footerComp().FooterLinkText();
            String expectedFooterLink = "http://elementalselenium.com";

            Assert.assertEquals(actualFooterComp,expectedFooterComp);
            Assert.assertEquals(actualFooterLink, expectedFooterLink);

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }

}
