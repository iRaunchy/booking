import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HotelPage;
import pages.MainPage;
import pages.SearchResultsPage;
import utils.CommonUtils;

import static framework.BasePage.initPage;
import static framework.WindowsHandler.switchBetweenTabs;
import static org.testng.Assert.*;
import static utils.DateTimeUtils.*;

public class BookingTest extends BaseTest {

    private MainPage mainPage;
    private SearchResultsPage searchResultsPage;
    private HotelPage hotelPage;

    @BeforeMethod(alwaysRun = true)
    public void before() {
        mainPage = initPage(MainPage.class);
        openWebSite();
    }

    @Test
    public void bookHotelTest() {
        mainPage.enterDestination("Los Angeles, California, USA");
        mainPage.enterDateRange(getCurrentDatePlusDays(1), getCurrentDatePlusMonths(1));
        searchResultsPage = mainPage.clickSearch();
        hotelPage = searchResultsPage.selectRandomTopHotel();
        switchBetweenTabs(1);
        hotelPage.selectCheapestRoom("1");
        hotelPage.clickReserve();
        assertTrue(CommonUtils.getPageUrl().contains("secure.booking.com"), "Checkout page was not opened.");
        System.out.println("test");
    }


    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
    }

}
