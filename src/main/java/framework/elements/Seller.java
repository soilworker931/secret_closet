package framework.elements;

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

    public void setSeller() {
        this.sellerName = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerName"), "seller name").getAttribute("text");
        this.sellerCity = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemSellerCity"), "seller city").getAttribute("text");;
    }
}
