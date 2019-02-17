package utils;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    public static final long WAIT_TIME = 45;

    public static void waitForElementVisibility(By element) {
        WebDriverWait wait = new WebDriverWait(BasePage.driver, WAIT_TIME);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitForElementVisibility(By element, int timeInSec) {
        WebDriverWait wait = new WebDriverWait(BasePage.driver, timeInSec);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitForTextPresent(WebElement element, int timeInSec, String text) {
        WebDriverWait wait = new WebDriverWait(BasePage.driver, timeInSec);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void waitForTextPresent(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(BasePage.driver, WAIT_TIME);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}
