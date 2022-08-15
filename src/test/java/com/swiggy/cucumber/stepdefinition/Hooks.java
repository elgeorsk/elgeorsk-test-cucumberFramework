package com.swiggy.cucumber.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import pageObjects.LandingPage;
import swiggy.factories.DriverFactory;

@Slf4j
public class Hooks {

    public static WebDriver driver;

    public static LandingPage landingPg;

    @Before
    public void setup() {
        driver = DriverFactory.getDriver();
        landingPg = new LandingPage(driver);
        log.info("Setup test - Browser opens");
    }

    @After
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
