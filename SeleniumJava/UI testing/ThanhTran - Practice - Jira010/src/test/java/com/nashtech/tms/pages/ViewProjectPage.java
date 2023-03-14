package com.nashtech.tms.pages;

import com.nashtech.tms.constants.locators.ViewProjectPageLocators;
import org.openqa.selenium.WebDriver;

public class ViewProjectPage extends BasePage{

    /** ---------------------- Constructor ------------------------ */
    public ViewProjectPage(WebDriver driver) {
        super(driver);
    }

    /** ---------------------- Page Methods ------------------------ */
    /** Get text element */
    public String getProjectName() { return getText(ViewProjectPageLocators.LBL_PROJECT_NAME); }

    public String getProjectType() { return getText(ViewProjectPageLocators.LBL_PROJECT_TYPE); }

    public String getProjectStatus() { return getText(ViewProjectPageLocators.LBL_PROJECT_STATUS); }

    public String getStartDate() { return getText(ViewProjectPageLocators.LBL_START_DATE); }

    public String getEndDate() { return getText(ViewProjectPageLocators.LBL_END_DATE); }

    public String getSizeDay() { return getText(ViewProjectPageLocators.LBL_SIZE_DAY); }

    public String getLocation() { return getText(ViewProjectPageLocators.LBL_LOCATION); }

    public String getProjectManager() { return getText(ViewProjectPageLocators.LBL_PROJECT_MANAGER); }

    public String getDeliveryManager() { return getText(ViewProjectPageLocators.LBL_DELIVERY_MANAGER); }

    public String getEngagementManager() { return getText(ViewProjectPageLocators.LBL_ENGAGEMENT_MANAGER); }

    public String getShortDescription() { return getText(ViewProjectPageLocators.LBL_SHORT_DESCRIPTION); }

    public String getLongDescription() { return getText(ViewProjectPageLocators.LBL_LONG_DESCRIPTION); }

    public String getTechnologies() { return getText(ViewProjectPageLocators.LBL_TECHNOLOGIES); }

    public String getClientName() { return getText(ViewProjectPageLocators.LBL_CLIENT_NAME); }

    public String getClientIndustry() { return getText(ViewProjectPageLocators.LBL_CLIENT_INDUSTRY); }

    public String getClientDescription() { return getText(ViewProjectPageLocators.LBL_CLIENT_DESCRIPTION); }
}
