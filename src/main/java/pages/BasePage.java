package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    Logger log = LoggerFactory.getLogger(BasePage.class);

    WebDriver driver;

    public void click(By byObj) {
        driver.findElement(byObj).click();
    }
}
