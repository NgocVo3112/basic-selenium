package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver getChromeDriver(){
        String currentProjectDirLocation = System.getProperty("user.dir");
        String chromeDriverLocation = null;
        if(OS.isFamilyMac())
            chromeDriverLocation = currentProjectDirLocation + "/src/test/resources/drivers/chromedriver";
        if(OS.isFamilyWindows())
            chromeDriverLocation = currentProjectDirLocation + "\\src\\test\\resources\\drivers\\chromedriver";
        if(chromeDriverLocation == null)
            throw new IllegalArgumentException ("Can't detect current OS");
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
