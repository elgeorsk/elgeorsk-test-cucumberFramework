package swiggy;

import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;
import swiggy.config.EnvFactory;
import swiggy.factories.DriverFactory;

@Slf4j
public class AppTest {

    private static Config config = EnvFactory.getInstance().getConfig();
    public static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    public static WebDriver driver;

    public static LandingPage landingPg;

    @BeforeTest
    public void setup() {
        driver = DriverFactory.getDriver();
        landingPg = new LandingPage(driver);
        log.info("Setup test - Browser opens");
    }

    @Test
    void assertThatHomePageTitleIsCorrect() {
        driver.get(HOME_PAGE_URL);
        Assert.assertEquals("Order food online from India's best food delivery service. Order from restaurants near you", driver.getTitle());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        try{
            driver.quit();
        }catch (Exception e){
            log.info("Browser closed already");
            e.printStackTrace();
        }
        log.info("Tear down - Browser closes");
    }
}
