import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaElementsPage {
    public static WebDriver driver;

    public DemoqaElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.get("https://demoqa.com/elements");
    }
    @FindBy(xpath="//*[@class=\"left-pannel\"]//div[@class=\"header-text\"][contains(text(), \"Elements\")]")
    WebElement ElementsAccord;

    @FindBy(xpath = "//*[@id=\"item-0\"]/span[contains(text(), \"Text Box\")]")
    WebElement TextBoxBtn;

    @FindBy(xpath = "//*[@id=\"item-1\"]/span[contains(text(), \"Check Box\")]")
    WebElement CheckBoxBtn;

    @FindBy(xpath = "//*[@class=\"btn btn-light \"]/span[contains(text(), \"Radio Button\")]")
    WebElement RadioBtn;

    @FindBy(xpath = "//*[@class=\"btn btn-light \"]/span[contains(text(), \"Web Tables\")]")
    WebElement WebTablesBtn;

    @FindBy(xpath = "//*/span[contains(text(), \"Buttons\")]")
    WebElement ButtonsBtn;

    @FindBy(xpath = "//*[@id=\"item-5\"]/span[contains(text(), \"Links\")]")
    WebElement LinksBtn;

    @FindBy(xpath = "//span[contains(text(), \"Broken Links\")]")
    WebElement BrokenLinksImagesBtn;

    @FindBy(xpath = "//span[contains(text(), \"Upload and Download\")]")
    WebElement UploadAndDownloadBtn;

    @FindBy(xpath = "//span[contains(text(), \"Dynamic Properties\")]")
    WebElement DynamicPropertiesBtn;

    @FindBy(xpath="//*[@class=\"element-group\"]//div[@class=\"header-text\"][contains(text(), \"Forms\")]")
    WebElement FormsAccord;

    @FindBy(xpath="//*[@class=\"group-header\"]//div[@class=\"header-text\"][contains(text(), \"Alerts, Frame & Windows\")]")
    WebElement AlertsFrameWindowsAccord;

    @FindBy(xpath="//*[@class=\"group-header\"]//div[@class=\"header-text\"][contains(text(), \"Widgets\")]")
    WebElement WidgetsAccord;

    @FindBy(xpath="//*[@class=\"element-group\"]//div[@class=\"header-text\"][contains(text(), \"Interactions\")]")
    WebElement IntaractionsAccord;

    @FindBy(xpath="//*[@class=\"element-group\"]//div[@class=\"header-text\"][contains(text(), \"Store\")]")
    WebElement BookStoreAppAccord;
}
