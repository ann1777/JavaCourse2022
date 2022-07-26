package Cucumber.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ContactSearchPageAndroid implements ContactSearchPage {

    public ContactSearchPageAndroid(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "main_search")
    private WebElement searchField;

    @FindBy(id = "name")
    private WebElement firstSearchResultName;

    public void search(String name) {
        searchField.sendKeys(name);
    }
    public void assertSearchResult(String expectedResult) {
        Assert.assertEquals(expectedResult, firstSearchResultName.getText());
    }
    public void navigateToSearchResultDetails() {
        firstSearchResultName.click();
    }
}