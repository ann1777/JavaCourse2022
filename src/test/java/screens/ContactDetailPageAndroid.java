package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailPageAndroid implements ContactDetailPage {

    public ContactDetailPageAndroid(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "detail_name")
    private WebElement contactName;

    @FindBy(id = "com.jayway.contacts:id/phonenumber")
    private WebElement contactPhone;

    public void assertContactName(String expectedName) {
        Assert.assertEquals(expectedName, contactName.getText());
    }

    @Override
    public void assertContactPhone(String expectedPhoneNumber) {
        Assert.assertEquals(expectedPhoneNumber, contactPhone.getText());
    }

    @Override
    public boolean waitDisplayed() {
        return contactName.isDisplayed();
    }
}
