package com.nachtech.tms.shared;

import com.nachtech.tms.pages.BasePage;
import com.nachtech.tms.utils.Pair;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

public class DatePicker extends BasePage {
    /** ---------------------- Locators of Web elements ------------------------ */
    private static final By BTN_PULL_LEFT = By.cssSelector("button.pull-left");
    private static final By BTN_MONTH_YEAR = By.cssSelector("button.uib-title strong");
    private static final By BTN_PULL_RIGHT = By.cssSelector("button.pull-right");
    private static final Pair<String, String> BTN_MONTH = Pair.of("xpath", "//table[@class='uib-monthpicker']//span[contains(text(),'%s')]/parent::button");
    private static final Pair<String, String> BTN_DAY = Pair.of("xpath", "//table[@class='uib-daypicker']//span[contains(text(),'%s')]/parent::button");

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
        clickElement(BTN_MONTH_YEAR);
        //Get current year of date picker
        int currentYear = Integer.parseInt(getText(BTN_MONTH_YEAR));

        /** Select year */
        //Move into expected year
        while(expectedYear != currentYear) {
            if(expectedYear < currentYear) {
                clickElement(BTN_PULL_LEFT);
            }
            else {
                clickElement(BTN_PULL_RIGHT);
            }
            //Get and update current year of date picker
            currentYear = Integer.parseInt(getText(BTN_MONTH_YEAR));
        }

        /** Select month */
        //Click on month in date picker
        clickElement(getByLocator(BTN_MONTH, expectedMonth));

        /** Select day */
        //Click on day in date picker
        clickElement(getByLocator(BTN_DAY, expectedDay));
    }
}
