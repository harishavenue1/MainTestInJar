package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
    private WebDriver driver;
    
    private By searchBox = By.name("q");
    
    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void navigateToGoogle() {
        driver.get("https://www.google.com");
    }
    
    public void searchFor(String searchTerm) {
        WebElement search = driver.findElement(searchBox);
        search.clear();
        search.sendKeys(searchTerm);
        search.submit();
    }
    
    public String getPageTitle() {
        return driver.getTitle();
    }
}