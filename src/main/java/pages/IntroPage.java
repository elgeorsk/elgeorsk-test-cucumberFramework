package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntroPage extends BasePage {
    Logger log = LoggerFactory.getLogger(IntroPage.class);

    public String HOME_PAGE_URL = "https://www.swiggy.com/";
    public String LOGIN_LABEL_CLASS = "x4bK8";
    public String SIGNUP_LABEL_CLASS = "r2iyh";

    public IntroPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigate() {
        driver.get(HOME_PAGE_URL);
    }

}
