package utils;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertNotNull;

public class CommonUtils {
   private static Random rand = new Random();

    public static void selectFromDropdownByValue(By locator, String value) {
        WebElement mySelectElement = BasePage.driver.findElement(locator);
        Select dropdown = new Select(mySelectElement);
        dropdown.selectByValue(value);
    }

    public static WebElement findWebElement(By locator) {
        return BasePage.driver.findElement(locator);
    }

    public static List<WebElement> findWebElements(By locator) {
        return BasePage.driver.findElements(locator);
    }

    public static WebElement findElementInList(List<WebElement> elements, String text) {
        WebElement foundElement = elements
                .stream()
                .filter((element) -> element.getText().replace("\n", " ").trim().equals(text))
                .findFirst().orElseThrow(() -> new RuntimeException("There is no element with the name " + text));
        return foundElement;
    }

    public static <T> T getRandomItem(List<T> list) {
        return list.get(rand.nextInt(list.size()));
    }

    public static void moveToElementAndClick(WebElement element) {
        Actions actions = new Actions(BasePage.driver);
        actions.moveToElement(element).click();
        actions.perform();
    }

    public static void refresh() {
        BasePage.driver.navigate().refresh();
    }

    public static String getPageUrl() {
        return BasePage.driver.getCurrentUrl();
    }

}
