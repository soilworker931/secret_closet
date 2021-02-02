package framework.test;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.application.MobileModule;
import framework.elements.Item;
import framework.elements.Seller;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import framework.screens.*;

public class Check {
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
        item.setItem();
        MAIN_SCREEN.clickFirstItem();
        Assert.assertTrue(ITEM_SCREEN.state().waitForDisplayed(), "Item page was not shown");
        Assert.assertTrue(ITEM_SCREEN.isCorrectItemOpened(item.getItemName(), item.getItemPrice(), item.getItemDiscount(), item.getItemPriceWithDiscount()), "Incorrect item is shown");
        seller.setSeller();
        ITEM_SCREEN.openSellerPage();
        Assert.assertTrue(SELLER_SCREEN.state().waitForDisplayed(), "Seller page was not shown");
        Assert.assertTrue(SELLER_SCREEN.isCorrectSellerDisplayed(seller.getSellerName(), seller.getSellerCity(), CITY), "Incorrect information is shown in the seller screen");
    }

    @AfterMethod
    public void closeApp() {
        AqualityServices.getApplication().quit();
    }
}