package ru.ulstu.tis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    private final static String APP_URL = "http://ya.ru";
    private final static String DRIVER_LOCATION = "/home/orion/geckodriver";

    public static void main(String[] args) {
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", DRIVER_LOCATION);
        driver = new FirefoxDriver();

        driver.get(APP_URL);
        String searchString = "QA automation";
        
        SearchPage page = PageFactory.initElements(driver, SearchPage.class);
        page.setSearchString(searchString);
        page.clickSubmitButton();
        
        System.out.println("Page title is: " + driver.getTitle());
        
        
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("qa");
            }
        });
        System.out.println("Page contains result? " + page.isResultContainsText(searchString));
        
        System.out.println("Page title is: " + driver.getTitle());
        
        
        driver.quit();
    }
}
