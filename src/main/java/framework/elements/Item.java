package framework.elements;

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

    public void setItem() {
        this.itemName = getElementFactory().getLabel(By.xpath("//android.widget.RelativeLayout[@index='0' and @resource-id='com.zdv.secretcloset:id/rlBanner']//android.widget.TextView"), "item name").getAttribute("text");
        this.itemPrice = getElementFactory().getLabel(By.xpath("//android.widget.RelativeLayout[@index='0' and @resource-id='com.zdv.secretcloset:id/rlBanner']//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvSumm']"), "price label").getAttribute("text");
        this.itemDiscount = getElementFactory().getLabel(By.xpath("//android.widget.RelativeLayout[@index='0' and @resource-id='com.zdv.secretcloset:id/rlBanner']//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvDiscount']"), "price label").getAttribute("text");
        this.itemPriceWithDiscount = getElementFactory().getLabel(By.xpath("//android.widget.RelativeLayout[@index='0' and @resource-id='com.zdv.secretcloset:id/rlBanner']//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvPrice']"), "price label").getAttribute("text");
    }
}