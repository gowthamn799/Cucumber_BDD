package utilities;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumActions {
    public WebElement getWebElementByXpath(String locator) {
        // Code to get a web element using Selenium WebDriver
       WebElement element=Hooks. driver.findElement(By.xpath(locator));
       return element;
    }
    public void clickElement(String locator) {
        // Code to click on an element using Selenium WebDriver
       WebElement element= getWebElementByXpath(locator);
       if (element.isEnabled() && element.isDisplayed()) {
           element.click();
       }
    }
    public void enterText(String locator, String text) {
        // Code to enter text into an input field using Selenium WebDriver
        WebElement element = getWebElementByXpath(locator);
        if (element.isEnabled() && element.isDisplayed()) {
            element.clear();
            element.click();
            element.sendKeys(text);
        }
    }
    public void delay(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public WebElement waitForVisible(String xpath, int seconds) {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    public String getText(String xpath) {
        return waitForVisible(xpath, 10).getText();
    }
}
