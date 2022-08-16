package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * LandingPage contains elements of initial visit at swiggy app
 */
public class LandingPage extends BasePage{

    public By login = By.xpath("//a[@class='x4bK8']");
    public By signup = By.xpath("//a[@class='r2iyh']");;
    public By deliveryLocationInput = By.id("location");

    public By locations = By.xpath("//button[contains(@class,'_3lmRa')]");
    public By findFoodBtn = By.xpath("//a[@class='_3iFC5']");

    public LandingPage (WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getWebDriver(){
        return this.driver;
    }

}