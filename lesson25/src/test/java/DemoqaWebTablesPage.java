import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoqaWebTablesPage extends DemoqaElementsPage {

    public DemoqaWebTablesPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/webtables");
    }

    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    WebElement addBtn;

    @FindBy(xpath = "//div[@class=\"ReactTable -striped -highlight\"]")
    WebElement usersTable;

    @FindBy(xpath = "//div[@class=\"rt-tbody\"]")
    WebElement tableBody;

    @FindBy(xpath = "//div[@class=\"rt-tr-group\"]")
    WebElement tableRow;
}
