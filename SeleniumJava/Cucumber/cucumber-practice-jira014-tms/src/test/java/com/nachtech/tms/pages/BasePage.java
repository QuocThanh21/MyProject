package com.nachtech.tms.pages;

import com.nachtech.tms.steps.StepHooks;
import com.nachtech.tms.utils.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    private WebDriverWait wait = new WebDriverWait(StepHooks.driver,
            Duration.ofSeconds(Long.parseLong(System.getProperty("TIMEOUT_IN_SECOND"))));

    /** ---------------------- Page Methods -----------------------*/
    /** Navigate */
    public void navigateToUrl(String url) {
        do try {
            StepHooks.driver.get(System.getProperty("BASE_URL") + url);
            break;
        } catch (WebDriverException ignored) { }
        while (true);
    }

    /** Convert locator */
    public static By convertToBy(String locatorType, String locatorValue) {
        switch (locatorType.toLowerCase()) {
            case "id":
                return By.id(locatorValue);
            case "name":
                return By.name(locatorValue);
            case "className":
                return By.className(locatorValue);
            case "tagName":
                return By.tagName(locatorValue);
            case "linkText":
                return By.linkText(locatorValue);
            case "partialLinkText":
                return By.partialLinkText(locatorValue);
            case "cssSelector":
                return By.cssSelector(locatorValue);
            default:
                return By.xpath(locatorValue);
        }
    }

    public static By getByLocator(Pair<String, String> elementPattern, String... elementLocatorValues) {
        String locatorValue = String.format(elementPattern.getValue(), elementLocatorValues);
        return convertToBy(elementPattern.getKey(),locatorValue);
    }

    /** Wait */
    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForVisibilityOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForInvisibilityOfElementLocated(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
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
    public void selectOptionOfDropdownByVisibleText(By locator, String text) {
        Select dropdownElement = new Select(waitForElementToBeClickable(locator));
        dropdownElement.selectByVisibleText(text);
    }

    /** Get text element*/
    public String getText(By locator) {
        WebElement element = waitForVisibilityOfElementLocated(locator);
        return element.getText();
    }
}
