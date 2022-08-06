package parallel;

import cucumber.api.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
//import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/parallel"},
        glue = {"com.github.automation.parallel"},
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"},
        monochrome = true,
        publish = true
)
public class ParallelRunner extends AbstractTestNGCucumberTests {

    @Override
//    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}

