package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    private ExtentManager() {}

    public static ExtentReports getExtent() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Framework", "Cucumber + Selenium");
            extent.setSystemInfo("Tester", "Gowtham");
        }
        return extent;
    }
}
