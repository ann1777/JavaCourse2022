package screens;

public interface ContactSearchPage {

    void search(String name);

    void assertSearchResult(String expectedResult);

    void navigateToSearchResultDetails();

    void searchBtnClick();

    void firstNameClick();

    void assertSearchResultNotification(String resultNotification);

    boolean waitDisplayed();
}
