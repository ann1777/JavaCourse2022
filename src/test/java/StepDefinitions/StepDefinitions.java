package StepDefinitions;

//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.Parameters;
import AppiumSupport.AppiumBaseClass;
import AppiumSupport.AppiumController;
import screens.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class StepDefinitions extends AppiumBaseClass {
    public ContactSearchPage searchPage;
    public ContactDetailPage detailPage;

//    private final DesiredCapabilities capabilities = new DesiredCapabilities();

    @Before
//    @Parameters({ "udid", "platformVersion" })
//    public void setUp(String udid, String platformVersion) throws IOException {
//        DesiredCapabilities caps = capabilities.getDesiredCapabilities(udid, platformVersion);
//        ThreadLocalDriver.setTLDriver(new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), caps));
    public void setUp() throws Exception {
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

    @After
    public synchronized void teardown() {
        AppiumController.instance.stop();
    }

    @Given("Search page is displayed")
    public void searchPageIsDisplayed() { Assert.assertTrue(searchPage.waitDisplayed()); }

    @When("I search for {string}")
    public void iSearchFor(String firstName) { searchPage.search(firstName); }

    @Then("Contact page is opened")
    public void ISeeContactPageIsDisplayed() { Assert.assertTrue(detailPage.waitDisplayed()); }

    @Then("the search result should be completed as this user {string}")
    public void iSeeSearchResultFullName(String fullName) {
        searchPage.assertSearchResult(fullName);
    }

    @Then("the search result should be completed with an {string} in the screen")
    public void iSeeResultNotificationUnderScreen(String resultNotification) {
        searchPage.assertSearchResultNotification(resultNotification);
    }

    @And("I click on contact in search result")
    public void iClickOnFullName() {
        searchPage.navigateToSearchResultDetails();
    }

    @Then("Contact details page is opened")
    public void detailPageIsDisplayed() {
        Assert.assertTrue(detailPage.waitDisplayed());
    }

    @Then("I see contact {string} on the Contact Detail page")
    public void iSeeFullNameIsCorrect(String fullName) {
        detailPage.assertContactName(fullName);
    }

    @Then("I see {string} is correct")
    public void iSeeContactPhoneIsCorrect(String contactPhone) {
        detailPage.assertContactPhone(contactPhone);
    }

    @When("I clear searchField")
    public void IClearSearchField()  {
        searchPage.searchFldClear();
    }

    @Then("the {string} is displayed under search field")
    public void theFirstSearchResultNameIsDisplayedUnderSearchField(String fullName) {
        searchPage.assertSearchResult(fullName);
    }
}