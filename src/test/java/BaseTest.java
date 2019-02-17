import framework.BasePage;
import framework.ScreenshotOnFailure;
import framework.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Listeners(ScreenshotOnFailure.class)

public class BaseTest {
    private static Settings settings = new Settings();
    public static Properties p = settings.loadSettings();

    @BeforeSuite
    public static void setUp() {
        settings.loadSettings();
        WebDriverManager.chromedriver().setup();
        BasePage.settings = settings;
        BasePage.driver = settings.getDriver();
        BasePage.driver.manage().window().maximize();
        BasePage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void openWebSite() {
        BasePage.driver.get(settings.getBaseUrl());
    }

    @AfterSuite
    public void cleanUp() {
        BasePage.driver.manage().deleteAllCookies();
        BasePage.driver.quit();
    }

}
