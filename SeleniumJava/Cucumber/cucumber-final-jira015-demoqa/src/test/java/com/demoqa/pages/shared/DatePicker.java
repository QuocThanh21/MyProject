package com.demoqa.pages.shared;

import com.demoqa.pages.BasePage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

public class DatePicker extends BasePage {
    /** ---------------------- Elements ------------------------ */
    private static final By DTP_DATE_OF_BIRTH = By.id("dateOfBirthInput");
    private static final By DDL_MONTH = By.xpath("//div[@class='react-datepicker']//select[contains(@class,'month-select')]");
    private static final By DDL_YEAR = By.xpath("//div[@class='react-datepicker']//select[contains(@class,'year-select')]");
    private static String BTN_DAY = "//div[@class='react-datepicker']//div[not(contains(@class,'outside-month')) and text()='%s']";

    /** ---------------------- Methods -----------------------*/
    public void selectDate(String dateString) {
        //Split and get expected day, month, year
        String[] expectedDate = StringUtils.split(dateString, " ");
        String expectedDay = expectedDate[0];
        String expectedMonthYear = expectedDate[1];
        String expectedMonth = StringUtils.split(expectedMonthYear, ",")[0];
        String expectedYear = StringUtils.split(expectedMonthYear, ",")[1];

        //Click to open Date picker
        clickElement(this.DTP_DATE_OF_BIRTH);
        selectOptionOfDropdownByVisibleText(this.DDL_MONTH, expectedMonth);
        selectOptionOfDropdownByValue(this.DDL_YEAR, expectedYear);
        clickElement(convertLocator("xpath", this.BTN_DAY, expectedDay));
    }
}
