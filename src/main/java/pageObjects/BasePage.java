package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    public WebDriver driver;

    public WebElement getWebElement(By by) {
        return this.driver.findElement(by);
    }

    public List<WebElement> getWebElements(By by) {
        return this.driver.findElements(by);
    }

    public List<WebElement> fluentWait(By by) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);

        List<WebElement> element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

        return  element;
    };
}
