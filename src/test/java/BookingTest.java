import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HotelPage;
import pages.MainPage;
import pages.SearchResultsPage;

import static framework.BasePage.initPage;
import static framework.WindowsHandler.switchBetweenTabs;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.CommonUtils.getPageUrl;
import static utils.DateTimeUtils.getCurrentDatePlusDays;
import static utils.DateTimeUtils.getCurrentDatePlusMonths;

public class BookingTest extends BaseTest {

    private MainPage mainPage;
    private SearchResultsPage searchResultsPage;
    private HotelPage hotelPage;
    private CheckoutPage checkoutPage;

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
        checkoutPage = hotelPage.clickReserve();
        assertEquals(checkoutPage.getCurrentProgressTitle(), "Enter your details", "Checkout page was not opened.");
    }


    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
    }

}
