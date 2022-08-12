package pageObjects;

import org.openqa.selenium.WebDriver;

public class RestaurantsPage extends BasePage {
    public Header header = new Header();

    public RestaurantsPage (WebDriver driver) {
        this.driver = driver;
    }
}
