package swiggy;

import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;
import pageObjects.RestaurantsPage;
import swiggy.config.EnvFactory;
import swiggy.factories.DriverFactory;
import utilities.ReadExcelData;

@Slf4j
public class ReachRestaurantPageTestPOI {
    private static final Config config = EnvFactory.getInstance().getConfig();
    public static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    public static WebDriver driver;

    public static LandingPage landingPg;

    public static RestaurantsPage restaurantsPg;

    public static ReadExcelData excelData = new ReadExcelData();

    @BeforeClass
    public void setup() {
        driver = DriverFactory.getDriver();
        landingPg = new LandingPage(driver);
        log.info("Setup test - Browser opens");
    }

    @Test (priority=1)
    void launchSwiggyApp(){
        landingPg.getWebDriver().get(HOME_PAGE_URL);
        Assert.assertEquals(excelData.ReadCellData(1,0), driver.getTitle());
    }

    @Test(priority = 2)
    void setDeliveryLocation(){
        landingPg.getWebElement(landingPg.deliveryLocationInput).sendKeys(excelData.ReadCellData(1,1));
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
        Assert.assertEquals(restaurantsPg.getWebElement(restaurantsPg.header.location).getAttribute("innerText"), excelData.ReadCellData(1,2));
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        try{
            driver.quit();
        }catch (Exception e){
            log.info("Browser closed already");
            log.error(e.toString());
        }
        log.info("Tear down - Browser closes");
    }
}
