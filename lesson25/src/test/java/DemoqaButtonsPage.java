import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoqaButtonsPage extends DemoqaElementsPage {

    public DemoqaButtonsPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/buttons");
    }

    @FindBy(xpath = "/html//button[@id='doubleClickBtn']")
    WebElement doubleClickMeBtn;

    @FindBy(xpath = "//*[@id=\"rightClickBtn\"]")
    WebElement rightClickMeBtn;

    @FindBy(css = "[class='mt-4']:nth-of-type(3)")
    WebElement clickMeBtn;
}
