import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class TestDemoqacom {
    WebDriver driwer;

    Actions actionbuilder;

    @BeforeTest
    public void setup(){
        //configure webdriver
        System.clearProperty("webdriver.chrome.driver");
        System.setProperty("webdriver.chrome.driver", "/home/angel/ideaProjects/test/lesson25/chromedriver");
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        ChromeOptions option = new ChromeOptions();
        //create webdriver example and manage it
        WebDriver driver = new ChromeDriver(option);
        actionbuilder = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //getting mainPage url from the conf.properties file
        driver.get(ConfProperties.getProperty("mainpage"));
        Path path = Paths.get("/usr/bin/chromedriver");
        boolean result = Files.isExecutable(path);
        System.out.println("File "+ path + " is Executable = " + result);
    }
    @Test
    public static void clickMeBtnDynamicMsg() {
        //initialise new chromedriver
        System.clearProperty("webdriver.chrome.driver");
        System.setProperty("webdriver.chrome.driver", "/home/angel/ideaProjects/test/lesson25/chromedriver");
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        ChromeOptions option = new ChromeOptions();
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/elements");
        WebElement pageTitle = driver.findElement(By.xpath("//div[@class=\"pattern-backgound playgound-header\"]/div[text()=\"Elements\"]"));
        Assert.assertEquals(pageTitle.getText(), "Elements", "Elements title is absent on the page");
//        assert pageTitle.getText().equals("Elements");

        // clicks on the Buttons
        WebElement buttons = driver.findElement(By.xpath("//span[text()=\"Buttons\"]"));
        buttons.click();

        //clicks Click Me button
        WebElement ClickMeBtn = driver.findElement(By.xpath("//button[text()=\"Click Me\"]"));
        ClickMeBtn.click();

        //reads and prints to the console text of the message appears
        WebElement TextMsg = driver.findElement(By.xpath("//p[@id=\"dynamicClickMessage\"]"));
        try {
            System.out.println(TextMsg.getText());
            Assert.assertEquals("You have done a dynamic click", TextMsg.getText(), "There is no text appears after clicking");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
        // prints the text of the message that appeared
        TextMsg.getText().trim();
    }

    @Test
    public static void fillOutRegistrationForm() {
        //initialise new chromedriver
        System.clearProperty("webdriver.chrome.driver");
        System.setProperty("webdriver.chrome.driver", "/home/angel/ideaProjects/test/lesson25/chromedriver");
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        ChromeOptions option = new ChromeOptions();
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");
        WebElement addBtn = driver.findElement(By.xpath("//*[text()='Add']"));
        addBtn.click();
        WebElement modalTitle = driver.findElement(By.xpath("//*[@id=\"registration-form-modal\"]"));
        Assert.assertEquals(modalTitle.getText(), "Registration Form", "The Registration Form title is absent");
//        assert modalTitle.getText().equals("Registration Form");

        //test Registration form fields
        WebElement firstNameFld = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstNameFld.sendKeys("Marry");
        Assert.assertEquals(firstNameFld.getText(), "Marry", "The person's name has not been added correctly");
//        assert firstNameFld.getText().equals("Marry");
//        Assert.assertNotNull(firstNameFld.getText());

        WebElement lastNameFld = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastNameFld.sendKeys("Poppins");
        Assert.assertEquals(lastNameFld.getText(), "Poppins", "The person's lastname has not been added correctly");
//        assert lastNameFld.getText().equals("Poppins");
//        Assert.assertNotNull(lastNameFld.getText());

        WebElement emailFld = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        emailFld.sendKeys("marry@gmail.com");
        Assert.assertEquals(emailFld.getText(), "marry@gmail.com", "The person's email has not been added correctly");
//        assert emailFld.getText().equals("marry@gmail.com");
//        Assert.assertNotNull(emailFld.getText());

        WebElement ageFld = driver.findElement(By.xpath("//*[@id=\"age\"]"));
        ageFld.sendKeys("21");
        Assert.assertEquals(ageFld.getText(), "21", "The person's age has not been added correctly");
//        assert ageFld.getText().equals("21");
//        Assert.assertNotNull(ageFld.getText());

        WebElement salaryFld = driver.findElement(By.xpath("//*[@id=\"salary\"]"));
        salaryFld.sendKeys("777770000000");
        Assert.assertEquals(salaryFld.getText(), "7777700000", "The person's salary has not been added correctly");
//        assert salaryFld.getText().equals("7777700000");
//        Assert.assertNotNull(salaryFld.getText());

        WebElement departmentFld = driver.findElement(By.xpath("//*[@id=\"department\"]"));
        departmentFld.sendKeys("Golden wishes");
        Assert.assertEquals(departmentFld.getText(), "Golden wishes", "The person's department has not been added correctly");
//        assert departmentFld.getText().equals("Golden wishes");
//        Assert.assertNotNull(departmentFld.getText());

        //submit changes
        WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        Assert.assertTrue(submitBtn.isDisplayed());
        submitBtn.click();

        // checks that the entry has been added
        WebElement fieldHasBeenAdded = driver.findElement(By.xpath("//*[text()='Marry']"));
        Assert.assertEquals(fieldHasBeenAdded.getText(), "Marry", "New entry has not been added to the users table");
    }
}
