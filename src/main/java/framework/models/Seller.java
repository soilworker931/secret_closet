package framework.models;

import org.openqa.selenium.By;

import static aquality.appium.mobile.application.AqualityServices.getElementFactory;

public class Seller {
    private String sellerName;
    private String sellerCity;

    public String getSellerName() {
        return sellerName;
    }

    public String getSellerCity() {
        return sellerCity;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setSellerCity(String sellerCity) {
        this.sellerCity = sellerCity;
    }
}
