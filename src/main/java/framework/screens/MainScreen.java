package framework.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import framework.models.Item;
import org.openqa.selenium.By;

public class MainScreen extends AndroidScreen {

    private final IButton cityButton = getElementFactory().getButton(By.id("com.zdv.secretcloset:id/tvToolbarCity"), "city button");
    private final IButton firstItemButton = getElementFactory().getButton
            (By.xpath("//android.widget.RelativeLayout[@index='0' and @resource-id='com.zdv.secretcloset:id/rlBanner']"),
                    "first item button");

    public MainScreen() {
        super(By.id("com.zdv.secretcloset:id/tvTitle"), "Secret closet");
    }

    public void clickCityButton() {
        AqualityServices.getLogger().info("Click city button");
        cityButton.click();
    }

    public void clickFirstItem() {
        AqualityServices.getLogger().info("Click first item button");
        firstItemButton.state().waitForDisplayed();
        firstItemButton.click();
    }

    public boolean isCorrectCitySelected(String city) {
        AqualityServices.getLogger().info("Check that correct city is opened: " + city);
        IButton cityButton = getElementFactory().getButton(By.xpath(String.format("//android.widget.TextView[@text='%s']", city)), "country button");
        return cityButton.state().waitForDisplayed();
    }

    public void setItem(Item item) {
        item.setItemName(getElementFactory().getLabel(
                By.xpath("//android.widget.RelativeLayout[@index='0' and @resource-id='com.zdv.secretcloset:id/rlBanner']//android.widget.TextView"),
                "item name").getAttribute("text"));
        item.setItemPrice(getElementFactory().getLabel(
                By.xpath("//android.widget.RelativeLayout[@index='0' and @resource-id='com.zdv.secretcloset:id/rlBanner']//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvSumm']"),
                "price label").getAttribute("text"));
        item.setItemDiscount(getElementFactory().getLabel(
                By.xpath("//android.widget.RelativeLayout[@index='0' and @resource-id='com.zdv.secretcloset:id/rlBanner']//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvDiscount']"),
                "price label").getAttribute("text"));
        item.setItemPriceWithDiscount(getElementFactory().getLabel(
                By.xpath("//android.widget.RelativeLayout[@index='0' and @resource-id='com.zdv.secretcloset:id/rlBanner']//android.widget.TextView[@resource-id='com.zdv.secretcloset:id/tvPrice']"),
                "price label").getAttribute("text"));
    }
}
