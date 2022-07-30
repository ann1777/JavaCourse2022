package StepDefinitions;

import AppiumSupport.AppiumBaseClass;
import AppiumSupport.AppiumController;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import screens.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DesireCapabilitiesUtil;
import utilities.ThreadLocalDriver;

import java.io.IOException;
import java.net.URL;

public class StepDefinitions extends AppiumBaseClass {
    public ContactSearchPage searchPage;
    public ContactDetailPage detailPage;

    private final DesireCapabilitiesUtil desiredCapabilitiesUtil = new DesireCapabilitiesUtil();

    @BeforeMethod
    @Parameters({ "udid", "platformVersion" })
    public void setUp(String udid, String platformVersion) throws IOException {
        DesiredCapabilities caps = desiredCapabilitiesUtil.getDesiredCapabilities(udid, platformVersion);
        ThreadLocalDriver.setTLDriver(new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), caps));
        AppiumController.instance.start();
        switch (AppiumController.executionOS) {
            case ANDROID:
            case ANDROID_BROWSERSTACK:
                searchPage = new ContactSearchPageAndroid(driver());
                detailPage = new ContactDetailPageAndroid(driver());
                break;
            case IOS:
            case IOS_BROWSERSTACK:
                searchPage = new ContactSearchPageIOS(driver());
                detailPage = new ContactDetailPageIOS(driver());
                break;
        }
    }

    @AfterMethod
    public synchronized void teardown() {
        AppiumController.instance.stop();
    }

    @Given("Search page is displayed")
    public void searchPageIsDisplayed() { Assert.assertTrue(searchPage.waitDisplayed()); }

    @When("I search for {string}")
    public void iSearchFor(String firstName) { searchPage.search(firstName); }

    @Then("the search result should be completed as this user {string}")
    public void iSeeInSearchResult(String fullName) {
        searchPage.assertSearchResult(fullName);
    }

    @Then("the search result should be completed with an {string} under screen")
    public void iSeeResultNotificationUnderScreen(String resultNotification) {
        searchPage.assertSearchResultNotification(resultNotification);
    }

    @And("I click on contact in search result")
    public void iClickOnFirstName() {
        searchPage.firstNameClick();
    }

    @And("I click on the search button")
    public void iClickOnSearchBtn() {
        searchPage.searchBtnClick();
    }

    @And("I navigate to the searchResultDetails page")
    public void detailPageIsDisplayed() {
        Assert.assertTrue(detailPage.waitDisplayed());
    }


    @Then("I see user {string} in the ContactName field")
    public void iSeeFullNameIsCorrect(String fullName) {
        detailPage.assertContactName(fullName);
    }

    @Then("I see contact phone {string} is correct")
    public void iSeeContactPhoneIsCorrect(String contactPhone) {
        detailPage.assertContactPhone(contactPhone);
    }
}