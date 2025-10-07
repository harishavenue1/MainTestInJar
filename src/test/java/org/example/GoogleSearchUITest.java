package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.GoogleSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class GoogleSearchUITest {
    private WebDriver driver;
    private GoogleSearchPage googlePage;
    
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        googlePage = new GoogleSearchPage(driver);
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Test(groups = "ui")
    public void testGoogleSearch() {
        googlePage.navigateToGoogle();
        googlePage.searchFor("Selenium WebDriver");
        
        Assert.assertTrue(googlePage.getPageTitle().contains("Selenium WebDriver"), 
                         "Search results should be displayed");
    }
}