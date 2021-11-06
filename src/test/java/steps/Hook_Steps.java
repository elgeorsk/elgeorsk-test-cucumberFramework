package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.IntroPage;
import utilities.SeleniumDriverManager;


public class Hook_Steps {
    Logger log = LoggerFactory.getLogger(Hook_Steps.class);

    SeleniumDriverManager driverManager = new SeleniumDriverManager();
    WebDriver driver;
    IntroPage introPage;

    @Before
    public void setup(){
        driverManager.setupDriver();
    }

    @Given("^Navigate to swiggy url")
    public void navigateToSwiggy(){
        driver = driverManager.getDriver();
        introPage = new IntroPage(driverManager.getDriver());
        introPage.navigate();
    }

    @When("^Pages is loaded")
    public void pageIsLoaded(){
        Assert.assertEquals("complete", new WebDriverWait(driver, 3000).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").toString()));
        log.info("Page is loaded");
//        introPage.getScreenShot(driver, "introPage");
    }

    @Then("^Validate the existence of \"Login\" text")
    public void loginLabelExists(){
        Assert.assertEquals(true, introPage.getWebDriver().findElement(By.className(introPage.LOGIN_LABEL_CLASS)).isDisplayed());
        log.info("Login label exists");
    }

    @Then("^Validate the existence of \"signup\" text")
    public void singUpLabelExists(){
        Assert.assertEquals(true, introPage.getWebDriver().findElement(By.className(introPage.SIGNUP_LABEL_CLASS)).isDisplayed());
        log.info("SignUp label exists");
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
        log.info("browser closed");
    }
}