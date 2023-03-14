package com.nashtech.tms.constants.locators;

import org.openqa.selenium.By;

public class DatePickerLocators {
    public static final By BTN_PULL_LEFT = By.cssSelector("button.pull-left");
    public static final By BTN_MONTH_YEAR = By.cssSelector("button.uib-title strong");
    public static final By BTN_PULL_RIGHT = By.cssSelector("button.pull-right");

    public static final By getBTN_MONTH_LOCATOR(String month) {
        return By.xpath(String.format("//table[@class='uib-monthpicker']//span[contains(text(),'%s')]/parent::button", month ));
    }

    public static final By getBTN_DAY_LOCATOR(String day) {
        return By.xpath(String.format("//table[@class='uib-daypicker']//span[contains(text(),'%s')]/parent::button", day ));
    }

}
