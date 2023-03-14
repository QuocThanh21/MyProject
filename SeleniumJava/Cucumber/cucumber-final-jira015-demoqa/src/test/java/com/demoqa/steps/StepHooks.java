package com.demoqa.steps;

import com.demoqa.utils.PropertiesFileUtil;
import com.demoqa.utils.api.AccountHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.awt.*;
import java.io.IOException;
import java.util.Properties;

import static com.demoqa.pages.BasePage.zoomOutBrowser;

public class StepHooks {
    public static WebDriver driver;
    public static String userToken;
    public static String expires;

    @BeforeAll
    public static void beforeAll() throws IOException {
        Properties properties = PropertiesFileUtil.loadPropertiesFromFile(System.getProperty("env.properties"));
        PropertiesFileUtil.appendSystemProperties(properties);
        String browser = System.getProperty("browser");
        if (StringUtils.isNoneEmpty(browser)) {
            System.setProperty("BROWSER_TYPE", browser);
        }

        //Get token and expires
        Response generateToken = AccountHelper.generateToken(System.getProperty("USERNAME"), System.getProperty("PASSWORD"));
        userToken = generateToken.jsonPath().getString("token");
        expires = generateToken.jsonPath().getString("expires");
    }

    @Before()
    public void beforeScenario(Scenario scenario) throws AWTException {
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

        do try {
            driver.get(System.getProperty("BASE_URL"));
            break;
        } catch (WebDriverException ignored) { }
        while (true);

        zoomOutBrowser(5);
    }

    @After()
    public void afterScenario(Scenario scenario) {
        driver.quit();
    }
}
