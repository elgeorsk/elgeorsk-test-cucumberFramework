package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.SeleniumDriverManager;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class BasePage {
    Logger log = LoggerFactory.getLogger(BasePage.class);

    WebDriver driver = SeleniumDriverManager.getWebDriver();

    public void click(By byObj) {
        driver.findElement(byObj).click();
    }

    public WebDriver getWebDriver(){
        return driver;
    }

    public void getScreenShot(WebDriver driver, String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("src/test/resources/screenshots/"+ fileName +"-"+ new Timestamp(System.currentTimeMillis()).getTime() +".png"));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
