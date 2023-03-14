package com.hoadoan.seleniumtestng.tests;

import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteClassListenerAdapter;
import com.hoadoan.seleniumtestng.utils.logs.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


@Listeners(ExtentIReporterSuiteClassListenerAdapter.class)
public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        Log.info("Tests is starting!");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        Log.info("Tests are ending!");
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
