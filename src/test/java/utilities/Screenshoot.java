package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Screenshoot {
    private Screenshoot() {}

    public static String capture(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            Path folder = Path.of("test-output", "screenshots");
            Files.createDirectories(folder);

            String fileName = name.replaceAll("[^a-zA-Z0-9-_]", "_") + ".png";
            Path dest = folder.resolve(fileName);

            Files.copy(src.toPath(), dest);
            return dest.toString(); // return path for Extent attach
        } catch (Exception e) {
            throw new RuntimeException("Screenshot capture failed", e);
        }
    }
    public static String captureBase64(WebDriver driver) {
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        } catch (Exception e) {
            throw new RuntimeException("Screenshot Base64 capture failed", e);
        }
    }
}
