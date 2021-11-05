package pages;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
    Logger log = LoggerFactory.getLogger(HomePage.class);

    String HOME_PAGE_URL = "https://www.swiggy.com/";

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void navigate() {
        driver.get(HOME_PAGE_URL);
    }
}
