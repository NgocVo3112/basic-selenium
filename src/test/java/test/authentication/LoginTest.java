package test.authentication;

import driver.DriverFactory;
import models.pages.Authentication.LoginPage;
import org.openqa.selenium.WebDriver;

import static url.Urls.baseURL;
import static url.Urls.loginSlug;

public class LoginTest {
    public static void main(String[] args) {
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
            System.out.println(loginPage.footerComp().FooterText());
            System.out.println(loginPage.footerComp().FooterLinkText());

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }



}
