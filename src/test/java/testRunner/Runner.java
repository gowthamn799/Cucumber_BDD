package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/featureFile",
        glue = {"stepDefination", "hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {
}
