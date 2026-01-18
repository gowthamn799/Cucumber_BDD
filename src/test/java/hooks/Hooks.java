package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ExtentManager;
import utilities.Screenshoot;



public class Hooks {

    public static WebDriver driver;
    private static final ExtentReports extent = ExtentManager.getExtent();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before
    public void setup(Scenario scenario) {
        ExtentTest extentTest = extent.createTest(scenario.getName());
        test.set(extentTest);
        test.get().info("Scenario Started: " + scenario.getName());
        // Initialize WebDriver here
        System.out.println("Setting up WebDriver");
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.navigate().to("https://demowebshop.tricentis.com/");
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            String base64 = Screenshoot.captureBase64(driver);

            test.get().fail("Scenario Failed: " + scenario.getName(),
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
        } else {
            test.get().pass("Scenario Passed: " + scenario.getName());
        }

        extent.flush();
        test.remove();
        // Quit WebDriver here
        System.out.println("Tearing down WebDriver");
        if (driver != null) {
            driver.quit();
        }
    }
}
