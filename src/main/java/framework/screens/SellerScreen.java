package framework.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import framework.models.Seller;
import org.openqa.selenium.By;

public class SellerScreen extends AndroidScreen {
    private ILabel sellerName = getElementFactory().getLabel
            (By.xpath("//android.view.ViewGroup[@resource-id='com.zdv.secretcloset:id/toolbar']/android.widget.TextView"),
                    "seller name");
    private ILabel sellerCity = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerCity"), "seller city");

    public SellerScreen() {
        super(By.id("com.zdv.secretcloset:id/tvItemSellerID"), "seller page");
    }

    public boolean isCorrectSellerNameDisplayed(Seller seller) {
        AqualityServices.getLogger().info("Check that correct Seller name is shown");
        return sellerName.getAttribute("text").equals(seller.getSellerName());
    }

    public boolean isCorrectSellerCityDisplayed(Seller seller) {
        AqualityServices.getLogger().info("Check that correct Seller city is shown");
        return sellerCity.getAttribute("text").equals(seller.getSellerCity());
    }

    public boolean isSellerFromCorrectCityDisplayed(String cityFromSearch) {
        AqualityServices.getLogger().info("Check that correct Seller city from search is shown");
        return sellerCity.getAttribute("text").equals(cityFromSearch);
    }

    public void setSeller(Seller seller) {
        seller.setSellerName(getElementFactory().getLabel(
                By.id("com.zdv.secretcloset:id/tvItemSellerName"),
                "seller name").getAttribute("text"));
        seller.setSellerCity(getElementFactory().getLabel(
                By.id("com.zdv.secretcloset:id/tvItemSellerCity"),
                "seller city").getAttribute("text"));
    }
}