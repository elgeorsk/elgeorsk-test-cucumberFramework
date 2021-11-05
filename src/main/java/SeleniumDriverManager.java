import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeleniumDriverManager {

    Logger log = LoggerFactory.getLogger(SeleniumDriverManager.class);

    WebDriver driver = null;

    static final String browserType = "CHROME";

    public WebDriver getDriver() {
        if (driver == null){
            setupDriver();
        }
        return driver;
    }

    public void setupDriver(){
        switch (browserType){
            case "CHROME":
                driver = setupChromeDriver();
            case "FIREFOX":
                // driver Firefox
        }
    }

    public ChromeDriver setupChromeDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized","--start-fullscreen");
        options.addArguments("--headless","--window-size=1920,1080");
        return new ChromeDriver(options);
    }
}
