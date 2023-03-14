package com.demoqa.pages;

import com.demoqa.steps.StepHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class BasePage {
    private WebDriverWait wait = new WebDriverWait(StepHooks.driver,
            Duration.ofSeconds(Long.parseLong(System.getProperty("TIMEOUT_IN_SECOND")))
    );

    /** ---------------------- Page Methods -----------------------*/
    /** Navigate */
    public void navigateToUrl(String url) {
        do try {
            StepHooks.driver.get(System.getProperty("BASE_URL") + url);
            break;
        } catch (WebDriverException ignored) { }
        while (true);
    }

    /** Zoom out */
    public static void zoomOutBrowser(int timesZoom) throws AWTException {
        Robot robot = new Robot();
        for(int i = 0; i < timesZoom; i++){
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }

    /** Convert locator */
    public static By convertLocator(String type, String locator, String replaceText) {
        switch (type) {
            case "id":
                return By.id(String.format(locator, replaceText));
            case "name":
                return By.name(String.format(locator, replaceText));
            case "className":
                return By.className(String.format(locator, replaceText));
            case "tagName":
                return By.tagName(String.format(locator, replaceText));
            case "linkText":
                return By.linkText(String.format(locator, replaceText));
            case "partialLinkText":
                return By.partialLinkText(String.format(locator, replaceText));
            case "cssSelector":
                return By.cssSelector(String.format(locator, replaceText));
            default:
                return By.xpath(String.format(locator, replaceText));
        }

    }

    /** Wait */
    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForVisibilityOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> waitForVisibilityOfAllElementsLocatedBy(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitAlertIsPresent() {
        wait.until(ExpectedConditions.alertIsPresent());
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
    public void selectOptionOfDropdownByVisibleText(By locator, String text) {
        Select dropdownElement = new Select(waitForElementToBeClickable(locator));
        dropdownElement.selectByVisibleText(text);
    }

    public void selectOptionOfDropdownByValue(By locator, String value) {
        Select dropdownElement = new Select(waitForElementToBeClickable(locator));
        dropdownElement.selectByValue(value);
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

    public String getAttributeOfElement(By locator, String attribute) {
        WebElement element = waitForVisibilityOfElementLocated(locator);
        return element.getAttribute(attribute);
    }
}
