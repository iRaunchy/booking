package pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.CommonUtils.findWebElements;
import static utils.CommonUtils.getRandomItem;

public class SearchResultsPage extends BasePage {

    protected static final String RANDOM_TOP3_HOTEL_LOCATOR = "(//div[not(contains(@class, 'soldout-property')) and contains(@class, 'sr_item')]//a[contains(@class, 'b-button_primary')])[position() < 4]";

    public HotelPage selectRandomTopHotel() {
        List<WebElement> elements = findWebElements(By.xpath(RANDOM_TOP3_HOTEL_LOCATOR));
        getRandomItem(elements).click();
        return initPage(HotelPage.class);
    }
}
