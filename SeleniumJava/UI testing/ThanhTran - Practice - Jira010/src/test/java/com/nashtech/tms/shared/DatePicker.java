package com.nashtech.tms.shared;

import com.nashtech.tms.constants.locators.DatePickerLocators;
import com.nashtech.tms.pages.BasePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

public class DatePicker extends BasePage {
    /** ---------------------- Constructor ------------------------ */
    public DatePicker(WebDriver driver) {
        super(driver);
    }

    /** ---------------------- Page Methods -----------------------*/
    /** Input element */
    public void selectDate(String dateString) {
        //Split dateString into day, month, year
        String[] expectDate = StringUtils.split(dateString, "-");
        //Get expected day, month, year
        int expectedYear = Integer.parseInt(expectDate[2]);
        String expectedMonth = expectDate[1];
        String expectedDay = expectDate[0];

        //Click on Title of date picker to see month year details
        clickElement(DatePickerLocators.BTN_MONTH_YEAR);
        //Get current year of date picker
        int currentYear = Integer.parseInt(getText(DatePickerLocators.BTN_MONTH_YEAR));

        /** Select year */
        //Move into expected year
        while(expectedYear != currentYear) {
            if(expectedYear < currentYear) {
                clickElement(DatePickerLocators.BTN_PULL_LEFT);
            }
            else {
                clickElement(DatePickerLocators.BTN_PULL_RIGHT);
            }
            //Get and update current year of date picker
            currentYear = Integer.parseInt(getText(DatePickerLocators.BTN_MONTH_YEAR));
        }

        /** Select month */
        //Click on month in date picker
        clickElement(DatePickerLocators.getBTN_MONTH_LOCATOR(expectedMonth));

        /** Select day */
        //Click on day in date picker
        clickElement(DatePickerLocators.getBTN_DAY_LOCATOR(expectedDay));
    }
}
