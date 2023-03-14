package com.hoadoan.seleniumtestng.pages;

import com.hoadoan.seleniumtestng.constants.ConfigConstants;
import com.hoadoan.seleniumtestng.utils.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    /**
     * Constructor
     */
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigConstants.TIMEOUT_IN_SECOND));
    }

    /**
     * Page Methods
     */
    public void navigate(String url){
        Log.info("Go to " + ConfigConstants.BASE_URL + url);
        driver.get(ConfigConstants.BASE_URL + url);
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForVisibilityOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void inputText(By locator, String text) {
        WebElement element = waitForElementToBeClickable(locator);
        element.sendKeys(text);
    }

    public void clickElement(By locator) {
        WebElement element = waitForElementToBeClickable(locator);
        element.click();
    }

    public String getText(By locator) {
        WebElement element = waitForVisibilityOfElementLocated(locator);
        return element.getText();
    }
}
