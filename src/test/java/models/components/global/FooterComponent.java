package models.components.global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterComponent {
    private final WebDriver driver;
    private final By footerTextSel = By.id("page-footer");
    private final By footerLinkTextSel = By.cssSelector("#page-footer a");


    public FooterComponent(WebDriver driver) {
        this.driver = driver;
    }

    public String FooterText() {
        return driver.findElement(footerTextSel).getText();
    }

    public String FooterLinkText() {
        return driver.findElement(footerLinkTextSel).getAttribute("href");
    }


}
