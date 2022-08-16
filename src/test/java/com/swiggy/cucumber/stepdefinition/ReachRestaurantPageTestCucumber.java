package com.swiggy.cucumber.stepdefinition;

import com.typesafe.config.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.RestaurantsPage;
import swiggy.config.EnvFactory;

import utilities.ReadExcelData;

@Slf4j
public class ReachRestaurantPageTestCucumber {
    private static final Config config = EnvFactory.getInstance().getConfig();
    public static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    public static LandingPage landingPg;
    public static RestaurantsPage restaurantsPg;
    public static ReadExcelData excelData = new ReadExcelData();

    @Given("User is on page \"https://www.swiggy.com\"$")
    public void launchSwiggyApp(){
        landingPg = Hooks.landingPg;
        landingPg.getWebDriver().get(HOME_PAGE_URL);
        Assert.assertEquals(excelData.ReadCellData(1,0), landingPg.driver.getTitle());
    }

    @When("Location is \"Ahmedabad\"$")
    public void setDeliveryLocation(){
        landingPg.getWebElement(landingPg.deliveryLocationInput).sendKeys(excelData.ReadCellData(2,1));
        landingPg.fluentWait(landingPg.locations);
        landingPg.getWebElements(landingPg.locations).get(0).click();
    }

    @Then("Reach restaurants page for \"Ahmedabad, Gujarat, India\"$")
    public void landingOnRestaurantPage() {
        restaurantsPg = new RestaurantsPage(landingPg.driver);
        restaurantsPg.fluentWait(restaurantsPg.header.location).get(0);
        Assert.assertEquals(restaurantsPg.getWebElement(restaurantsPg.header.location).getAttribute("innerText"), excelData.ReadCellData(2,2));
    }
}
