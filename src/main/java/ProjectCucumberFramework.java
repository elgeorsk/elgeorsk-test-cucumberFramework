import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class ProjectCucumberFramework {

    public static void main(String args[]) throws InterruptedException, IOException {

        Logger log = LoggerFactory.getLogger(ProjectCucumberFramework.class);

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized","--start-fullscreen");
        options.addArguments("--headless","--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(options);
        Thread.sleep(2000);

        TakesScreenshot ts = (TakesScreenshot) driver;

        log.info("Initial webdriver");

        driver.get("https://www.swiggy.com/");
        Thread.sleep(2000);

        // swiggy home page screenshot
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("src/main/resources/screenshots/swiggyHomePage-"+ new Timestamp(System.currentTimeMillis()).getTime() +".png"));
        log.info("Swiggy.com homePage");

        // close driver
        Thread.sleep(5000);
        driver.close();
        driver.quit();
        log.info("webdriver closed");
    }
}
