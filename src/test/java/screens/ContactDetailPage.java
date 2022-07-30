package screens;

public interface ContactDetailPage {

    void assertContactName(String expectedName);

    void assertContactPhone(String contactPhone);

    boolean waitDisplayed();
}
