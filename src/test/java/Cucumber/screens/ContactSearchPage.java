package Cucumber.screens;

import org.openqa.selenium.WebElement;

public interface ContactSearchPage {

    void search(String name);

    void assertSearchResult(String expectedResult);

    void navigateToSearchResultDetails();
}
