package swiggy;

import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.RestaurantsPage;
import swiggy.config.EnvFactory;
import swiggy.factories.DriverFactory;

@Slf4j
public class ReachRestaurantPageTest {
    private static Config config = EnvFactory.getInstance().getConfig();
    public static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    public static WebDriver driver;

    public static LandingPage landingPg;

    public static RestaurantsPage restaurantsPg;

    @BeforeTest
    public void setup() {
        driver = DriverFactory.getDriver();
        landingPg = new LandingPage(driver);
        log.info("Setup test - Browser opens");
    }

    @Test (priority=1)
    void launchSwiggyApp(){
        landingPg.driver.get(HOME_PAGE_URL);
        Assert.assertEquals("Order food online from India's best food delivery service. Order from restaurants near you", driver.getTitle());
    }

    @Test(priority = 2)
    void setDeliveryLocation(){
        landingPg.getWebElement(landingPg.deliveryLocationInput).sendKeys("Delhi");
        landingPg.fluentWait(landingPg.locations);
    }

    @Test(priority = 3)
    void findRestaurants() {
        landingPg.getWebElements(landingPg.locations).get(0).click();
    }

    @Test(priority = 4)
    void landingOnRestaurantPage() {
        restaurantsPg = new RestaurantsPage(driver);
        restaurantsPg.fluentWait(restaurantsPg.header.location).get(0);
        Assert.assertEquals(restaurantsPg.getWebElement(restaurantsPg.header.location).getAttribute("innerText"), "Delhi, India");
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
