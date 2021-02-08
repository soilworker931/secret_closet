import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.application.MobileModule;
import framework.models.Item;
import framework.models.Seller;
import framework.screens.*;
import framework.utils.Appium;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecretClosetTest {
    private Appium appium = new Appium();
    private static final MainScreen MAIN_SCREEN = new MainScreen();
    private static final CitiesScreenAlert CITIES_SCREEN_ALERT = new CitiesScreenAlert();
    private static final CitySearchScreen CITY_SEARCH_SCREEN = new CitySearchScreen();
    private static final ItemScreen ITEM_SCREEN = new ItemScreen();
    private static final SellerScreen SELLER_SCREEN = new SellerScreen();
    private static final String CITY = "Dubai";
    private Item item = new Item();
    private Seller seller = new Seller();

    @BeforeMethod
    public void testFunc() {
        appium.startServer();
        System.clearProperty("profile");
        AqualityServices.initInjector(new MobileModule(AqualityServices::getApplication));
    }

    @Test
    public void startTest() {
        Assert.assertTrue(MAIN_SCREEN.state().isDisplayed(), "Main screen was not shown");
        MAIN_SCREEN.clickCityButton();
        CITIES_SCREEN_ALERT.state().waitForExist();
        Assert.assertTrue(CITIES_SCREEN_ALERT.state().isDisplayed(), "Cities screen was not shown");
        CITIES_SCREEN_ALERT.clickOkButton();
        CITY_SEARCH_SCREEN.searchAndSelectCity(CITY);
        Assert.assertTrue(MAIN_SCREEN.isCorrectCitySelected(CITY), "Incorrect city is shown");
        MAIN_SCREEN.setItem(item);
        MAIN_SCREEN.clickFirstItem();
        Assert.assertTrue(ITEM_SCREEN.state().waitForDisplayed(), "Item page was not shown");
        Assert.assertTrue(ITEM_SCREEN.isCorrectItemNameDisplayed(item), "Incorrect item name is shown");
        Assert.assertTrue(ITEM_SCREEN.isCorrectItemPriceWithDiscountDisplayed(item), "Incorrect item price with discount is shown");
        Assert.assertTrue(ITEM_SCREEN.isCorrectItemPriceDisplayed(item), "Incorrect item price is shown");
        Assert.assertTrue(ITEM_SCREEN.isCorrectDiscountDisplayed(item), "Incorrect item discount is shown");
        SELLER_SCREEN.setSeller(seller);
        ITEM_SCREEN.openSellerPage();
        Assert.assertTrue(SELLER_SCREEN.state().waitForDisplayed(), "Seller page was not shown");
        Assert.assertTrue(SELLER_SCREEN.isCorrectSellerNameDisplayed(seller), "Incorrect seller name is shown");
        Assert.assertTrue(SELLER_SCREEN.isCorrectSellerCityDisplayed(seller), "Incorrect seller city is shown");
        Assert.assertTrue(SELLER_SCREEN.isSellerFromCorrectCityDisplayed(CITY), "Incorrect seller city from search is shown");
    }

    @AfterMethod
    public void closeApp() {
        appium.stopServer();
        AqualityServices.getApplication().quit();
    }
}