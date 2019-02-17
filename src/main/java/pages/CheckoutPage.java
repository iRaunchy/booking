package pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.CommonUtils.findWebElements;
import static utils.CommonUtils.getRandomItem;

public class CheckoutPage extends BasePage {

    @FindBy(css = ".bui-nav-progress__item--active .bui-nav-progress__title")
    WebElement currentProgressTitle;

    public String getCurrentProgressTitle() {
        return currentProgressTitle.getText();
    }
}
