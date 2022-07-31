package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactDetailPageAndroid implements ContactDetailPage {

//    private MobileElement mobileElement;

    public ContactDetailPageAndroid(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "detail_name")
//    private MobileElement contactName;
    private WebElement contactName;

    @FindBy(id = "com.jayway.contacts:id/phonenumber")
//    private MobileElement contactPhone;
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
//        boolean isElementPresent;
//        try {
//            mobileElement =  (AppiumDriver) driver().findElementByAndroidUIAutomator("UiSelector().resourceId(\""+targetResourceId+"\")");
//            WebDriverWait wait = new WebDriverWait(mobileElement.getWrappedDriver(), timeLimitInSeconds);
//            wait.until(ExpectedConditions.visibilityOf(mobileElement));
//            isElementPresent = mobileElement.isDisplayed();
//            return isElementPresent;
//        }catch (Exception e) {
//            isElementPresent = false;
//            System.out.println(e.getMessage());
//            return isElementPresent;
//        }
        return false;
    }
}
