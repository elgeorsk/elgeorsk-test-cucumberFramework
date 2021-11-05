import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {
    Logger log = LoggerFactory.getLogger(Hooks.class);
    public static WebDriver driver = null;

    @Before
    public void beforeScenario(){
        //start the browser
        driver = new SeleniumDriverManager().getDriver();
    }

    @After
    public void afterScenario() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        driver.quit();
        log.info("webdriver closed");
    }
}
