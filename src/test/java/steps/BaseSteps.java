package steps;

import io.appium.java_client.android.AndroidDriver;

public class BaseSteps {
    protected ContactDetailPage contactDetailPage;
    protected ContactDetailPageAndroid contactDetailPageAndroid;
    protected ContactDetailPageIOS contactDetailPageIOS;
    protected ContactSearchPage contactSearchPage;
    protected ContactSearchPageAndroid contactSearchPageAndroid;
    protected ContactSearchPageIOS contactSearchPageIOS;

    public void setupScreens(AndroidDriver driver) {
        contactDetailPage = new ContactDetailPage() {
            @Override
            public void assertContactName(String expectedName) {

            }
        };
        contactDetailPageAndroid = new ContactDetailPageAndroid(driver);
        contactDetailPageIOS = new ContactDetailPageIOS(driver);
        contactSearchPage = new ContactSearchPage() {
            @Override
            public void search(String name) {

            }

            @Override
            public void assertSearchResult(String expectedResult) {

            }

            @Override
            public void navigateToSearchResultDetails() {

            }
        };
        contactSearchPageAndroid = new ContactSearchPageAndroid(driver);
        contactSearchPageIOS = new ContactSearchPageIOS(driver);
    }
}
