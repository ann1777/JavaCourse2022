import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaMainPage {
    public WebDriver driver;

    public DemoqaMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.get("https://demoqa.com/");
    }
    @FindBy(xpath="//*[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]")
    WebElement ElementsCard;

    @FindBy(xpath = "//*[@class=\"card-body\"]//h5[contains(text(),\"Forms\")]")
    WebElement FormsCard;

    @FindBy(xpath = "//*[@class=\"card-body\"]//h5[contains(text(),\"Alerts, Frame & Windows\")]")
    WebElement AlertsFrameWindowsCard;

    @FindBy(xpath = "//*[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]")
    WebElement Widgets;

    @FindBy(xpath = "//*[@class=\"card-body\"]//h5[contains(text(),\"Interactions\")]")
    WebElement Interactions;

    @FindBy(xpath = "//*[@class=\"card-body\"]//h5[contains(text(),\"Book Store Application\")]")
    WebElement BookStoreApplication;
}
