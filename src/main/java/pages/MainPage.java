package pages;

import framework.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

import static utils.CommonUtils.*;
import static utils.WaitUtils.*;

public class MainPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(MainPage.class.getName());

    @FindBy(id = "ss")
    protected WebElement destinationInput;

    @FindBy(css = ".sb-searchbox__button")
    protected WebElement searchButton;

    protected static final String DESTINATION_OPTION_LOCATOR = "//*[@data-label = '%s']/span[1]";
    protected static final String DATE_FROM_TABLE_LOCATOR = "(//*[contains(@class, 'bui-calendar__dates')])[1]//*[contains(@data-date, '%s')]";
    protected static final String DATE_TO_TABLE_LOCATOR = "(//*[contains(@class, 'bui-calendar__dates')])[2]//*[contains(@data-date, '%s')]";

    public void enterDestination(String destination) {
        destinationInput.sendKeys(destination);
        String xpath = String.format(DESTINATION_OPTION_LOCATOR, destination);
        waitForElementVisibility(By.xpath(xpath));
        findWebElement(By.xpath(xpath)).click();
    }

    public void enterDateRange(String dateFrom, String dateTo) {
        findWebElement(By.xpath(String.format(DATE_FROM_TABLE_LOCATOR, dateFrom))).click();
        findWebElement(By.xpath(String.format(DATE_TO_TABLE_LOCATOR, dateTo))).click();
    }

    public SearchResultsPage clickSearch() {
        searchButton.click();
        return initPage(SearchResultsPage.class);
    }

}
