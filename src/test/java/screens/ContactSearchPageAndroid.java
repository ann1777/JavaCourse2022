package screens;

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

    @FindBy(xpath = "//android.widget.TextView [@resource-id=\"com.jayway.contacts:id/main_text\"]")
    private WebElement resultNotification;

    public void search(String name) {
        searchField.sendKeys(name);
    }

    @Override
    public void assertSearchResultNotification(String expectedResultNotification ) {
        Assert.assertEquals(expectedResultNotification, resultNotification.getText());
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
    public boolean waitDisplayed() {
        return searchField.isDisplayed();
    }

    @Override
    public void searchFldClear() { searchField.clear(); }

}