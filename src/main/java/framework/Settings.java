package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {
    public static Properties p = new Properties();


    public Properties loadSettings() {
        String fileName = "src/test/resources/config.properties";
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(fileName);
            if (fileInputStream == null) {
                throw new FileNotFoundException(String.format("Property file %s is not found in the classpath", fileName));
            }
            p.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }

    public String getBaseUrl() {
        return p.getProperty("base.url");
    }

    public WebDriver getDriver() {
        return new ChromeDriver();
    }
}
