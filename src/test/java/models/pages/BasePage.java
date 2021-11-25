package models.pages;

import Utils.page.ScrollHandler;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private  WebDriver driver;
    private JavascriptExecutor javascriptExecutor;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        javascriptExecutor = (JavascriptExecutor) driver;
    }
    public void ScrollToTop(){
        ScrollHandler.srcollToTop(javascriptExecutor);
    }
    public void ScrollToBottom(){
        ScrollHandler.srcollToBottom(javascriptExecutor);
    }
}
