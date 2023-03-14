package com.nashtech.tms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    /** ---------------------- Constructor ------------------------ */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(System.getProperty("TIMEOUT_IN_SECOND"))));
    }

    /** ---------------------- Page Methods -----------------------*/
    /** Navigate */
    public void navigateToUrl(String url) {
        driver.get(System.getProperty("BASE_URL") + url);
    }

    /** Wait */
    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForVisibilityOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForVisibilityOfWebElement(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public List<WebElement> waitForVisibilityOfAllElementsLocatedBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    /** Find element */
    public List<WebElement> findAllWebElements(By locator) {
        return waitForVisibilityOfAllElementsLocatedBy(locator);
    }

    /** Click element */
    public void clickElement(By locator) {
        WebElement element = waitForElementToBeClickable(locator);
        element.click();
    }

    /** Input text */
    public void inputText(By locator, String text) {
        WebElement element = waitForElementToBeClickable(locator);
        element.clear();
        element.sendKeys(text);
    }

    /** Select option of dropdown */
    public void selectOptionOfDropdownByVisibleText(By locator, String option) {
        Select dropdownElement = new Select(waitForElementToBeClickable(locator));
        dropdownElement.selectByVisibleText(option);
    }

    /** Clear to element is empty */
    public void clearElement(By locator) {
        WebElement element = waitForElementToBeClickable(locator);
        element.clear();
    }

    /** Get text element*/
    public String getText(By locator) {
        WebElement element = waitForVisibilityOfElementLocated(locator);
        return element.getText();
    }

    public String getText(WebElement webElement) {
        WebElement element = waitForVisibilityOfWebElement(webElement);
        return element.getText();
    }

    public String getErrorMessage(By locator) {
        return getText(locator);
    }
}
