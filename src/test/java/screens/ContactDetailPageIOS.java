package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class ContactDetailPageIOS implements ContactDetailPage {

    public ContactDetailPageIOS(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//XCUIElementTypeApplication[@name=\"Contacts\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    private WebElement contactName;

    @FindBy(xpath = "//XCUIElementTypeApplication[@name=\"Contacts\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
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
        return contactPhone.isDisplayed();
    }
}
