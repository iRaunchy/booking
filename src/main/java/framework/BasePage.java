package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.CommonUtils;

import static utils.CommonUtils.findWebElement;

public class BasePage {
    public static WebDriver driver;
    public static Settings settings;
    public Logger logger = LoggerFactory.getLogger(BasePage.class);

    protected static final By PAGE_TITLE_CSS = By.cssSelector("#main > h1");

    public static <T extends BasePage> T initPage(Class<T> pageClass) {
        return PageFactory.initElements(driver, pageClass);
    }

    public String getPageTitle() {
        return findWebElement(PAGE_TITLE_CSS).getText();
    }


}
