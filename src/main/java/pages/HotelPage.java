package pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static utils.CommonUtils.*;

public class HotelPage extends BasePage {

    @FindBy(css = ".js-reservation-button")
    WebElement reservationButton;

    @FindBy(css = ".hprt-price-price")
    List<WebElement> rooms;

    protected static final String ROOM_QTY_LOCATOR = "(//*[contains(@class, 'hprt-nos-select')])[%s]";


    public void selectCheapestRoom(String qty) {
        List<Integer> prices = getListOfPrices();

        int minIndex = IntStream.range(0, prices.size()).boxed()
                .min(comparingInt(prices::get))
                .get();

        selectFromDropdownByValue(By.xpath(String.format(ROOM_QTY_LOCATOR, String.valueOf(minIndex + 1))), qty);
    }

    private List<Integer> getListOfPrices() {
        String onlyDigitsRegEx = "[^\\d.]";
        return rooms.stream().map(element -> Integer.parseInt(element.getText().replaceAll(onlyDigitsRegEx, "").trim())).collect(Collectors.toList());
    }

    public void clickReserve() {
        reservationButton.click();
    }
}
