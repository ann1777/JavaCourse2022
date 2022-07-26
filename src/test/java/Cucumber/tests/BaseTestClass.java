package Cucumber.tests;
import AppiumSupport.AppiumBaseClass;
import Cucumber.screens.*;
import Cucumber.utilities.DesireCapabilitiesUtil;
import Cucumber.utilities.ThreadLocalDriver;
import io.appium.java_client.android.AndroidDriver;
import AppiumSupport.AppiumController;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;

public class BaseTestClass extends AppiumBaseClass{
    ContactSearchPage searchPage;
    ContactDetailPage detailPage;

    private final DesireCapabilitiesUtil desiredCapabilitiesUtil = new DesireCapabilitiesUtil();

    @BeforeMethod
    @Parameters({ "udid", "platformVersion" })
    public void setUp(String udid, String platformVersion) throws IOException {
        DesiredCapabilities caps = desiredCapabilitiesUtil.getDesiredCapabilities(udid, platformVersion);
        ThreadLocalDriver.setTLDriver(new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"), caps));
        AppiumController.instance.start();
        switch (AppiumController.executionOS) {
            case ANDROID:
            case ANDROID_BROWSERSTACK:
                searchPage = new ContactSearchPageAndroid(driver());
                detailPage = new ContactDetailPageAndroid(driver());
                break;
            case IOS:
            case IOS_BROWSERSTACK:
                searchPage = new ContactSearchPageIOS(driver());
                detailPage = new ContactDetailPageIOS(driver());
                break;
        }
    }

    @AfterMethod
    public synchronized void teardown() {
        AppiumController.instance.stop();
    }
}
