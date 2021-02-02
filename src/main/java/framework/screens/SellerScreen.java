package framework.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import org.openqa.selenium.By;

public class SellerScreen extends AndroidScreen {
    private ILabel sellerName = getElementFactory().getLabel(By.xpath("//android.widget.TextView"), "seller name");
    private ILabel sellerCity = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerCity"), "seller city");

    public SellerScreen() {
        super(By.id("com.zdv.secretcloset:id/tvItemSellerID"), "seller page");
    }

    public boolean isCorrectSellerDisplayed(String name, String city, String cityFromSearch) {
        AqualityServices.getLogger().info("Check that correct Seller screen is opened");
        if (sellerName.getAttribute("text").equals(name)
        && sellerCity.getAttribute("text").equals(city)
        && sellerCity.getAttribute("text").equals(cityFromSearch)) {
            return true;
        } else {
            return false;
        }
    }
}