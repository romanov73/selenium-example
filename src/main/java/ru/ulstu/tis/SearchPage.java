package ru.ulstu.tis;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SearchPage {
    @FindBy(xpath = "//*[@id='text']")
    private WebElement inputField;
    @FindBy(xpath="/html/body/table/tbody/tr[2]/td/form/div[2]/button")
    private WebElement startSearchButton;    
    @FindBys(@FindBy(xpath = "//div[@class='main__content']//a"))
    private List<WebElement> links;
    
    public SearchPage setSearchString(String text){
        inputField.sendKeys(text);
        return this;
    }
    
    public void clickSubmitButton() {
        startSearchButton.click();
    }
    
    public boolean isResultContainsText(String text) {
        return links.stream().filter(link -> link.getText().contains(text)).findAny().isPresent();
    }
}
