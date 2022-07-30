package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactSearchPageIOS implements ContactSearchPage {

    public ContactSearchPageIOS(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Search for contact\"]")
    private WebElement searchField;

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"Search results\"]/XCUIElementTypeCell/XCUIElementTypeStaticText")
    private WebElement firstSearchResultName;

    public void search(String name) {
        searchField.click();
        searchField.sendKeys(name);
    }

    public void assertSearchResult(String expectedResult) {
        Assert.assertEquals(expectedResult, firstSearchResultName.getText());
    }

    public void navigateToSearchResultDetails() {
        firstSearchResultName.click();
    }

    @Override
    public void searchBtnClick() {

    }

    @Override
    public void firstNameClick() {

    }

    @Override
    public void assertSearchResultNotification(String resultNotification) {

    }

    @Override
    public boolean waitDisplayed() {
        return false;
    }
}
