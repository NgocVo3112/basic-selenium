package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class lession13_1 implements Urls {
    public static void main(String[] args){
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            driver.get(baseURL.concat(dynamic_Controls));
            By btnSel = By.cssSelector("button");
            List<WebElement> btnElms = driver.findElements(btnSel);
            System.out.println("Elm size : " + btnElms.size());
            final int CHECKBOX_EXAMPLE_BTN_INDEX = 0;
            final int INPUT_EXAMPLE_BTN_INDEX = 1;
            WebElement checkboxExampleBtnElm = btnElms.get(CHECKBOX_EXAMPLE_BTN_INDEX);
            WebElement inputExampleBtnElm = btnElms.get(INPUT_EXAMPLE_BTN_INDEX);
            checkboxExampleBtnElm.click();
            inputExampleBtnElm.click();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
