package framework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ScreenshotOnFailure extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        WebDriver driver = BasePage.driver;

        SimpleDateFormat dataFormat = new SimpleDateFormat("dd.MM.yyyy hh.mm.ss");
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        String fileName = String.format("target\\screenshots\\failureReport %s.png", dataFormat.format(date));
        try {
            FileUtils.copyFile(screenshot, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
