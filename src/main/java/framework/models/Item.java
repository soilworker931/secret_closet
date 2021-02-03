package framework.models;

import org.openqa.selenium.By;

import static aquality.appium.mobile.application.AqualityServices.getElementFactory;

public class Item {
    private String itemName;
    private String itemPrice;
    private String itemDiscount;
    private String itemPriceWithDiscount;

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemDiscount() {
        return itemDiscount;
    }

    public String getItemPriceWithDiscount() {
        return itemPriceWithDiscount;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemDiscount(String itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public void setItemPriceWithDiscount(String itemPriceWithDiscount) {
        this.itemPriceWithDiscount = itemPriceWithDiscount;
    }
}