package com.nashtech.tms.tests;

import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteClassListenerAdapter;
import com.nashtech.tms.utils.PropertiesFileUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.Properties;

@Listeners(ExtentIReporterSuiteClassListenerAdapter.class)
public class BaseTest {
    public WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void beforeSuite(String browser) throws IOException {
        Properties properties = PropertiesFileUtil.loadPropertiesFromFile(System.getProperty("env.properties"));
        PropertiesFileUtil.appendSystemProperties(properties);
        if (StringUtils.isNoneEmpty(browser)) {
            System.setProperty("BROWSER_TYPE", browser);
        }
    }

    @BeforeMethod
    public void beforeMethodBaseTest() {
        //Initialize and setup driver
        String browserType = System.getProperty("BROWSER_TYPE");
        switch (browserType) {
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(System.getProperty("BASE_URL"));
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
