package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class StartBrowser implements Urls{

    public static void main(String[] args){
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(baseURL);
        driver.quit();
    }

}
