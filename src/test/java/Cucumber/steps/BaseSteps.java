package Cucumber.steps;

import Cucumber.pages.ContactSearchPageAndroid;
import Cucumber.pages.ContactSearchPageIOS;
import Cucumber.pages.ContactDetailPageAndroid;
import Cucumber.pages.ContactDetailPageIOS;

import io.appium.java_client.android.AndroidDriver;

public class BaseSteps {
//    protected ContactDetailPage contactDetailPage;
    protected ContactDetailPageAndroid contactDetailPageAndroid;
    protected ContactDetailPageIOS contactDetailPageIOS;
//    protected ContactSearchPage contactSearchPage;
    protected ContactSearchPageAndroid contactSearchPageAndroid;
    protected ContactSearchPageIOS contactSearchPageIOS;

    public void setupScreens(AndroidDriver driver) {
//        contactDetailPage = new ContactDetailPage(driver);
        contactDetailPageAndroid = new ContactDetailPageAndroid(driver);
        contactDetailPageIOS = new ContactDetailPageIOS(driver);
//        contactSearchPage = new ContactSearchPage(driver);
        contactSearchPageAndroid = new ContactSearchPageAndroid(driver);
        contactSearchPageIOS = new ContactSearchPageIOS(driver);
    }
}
