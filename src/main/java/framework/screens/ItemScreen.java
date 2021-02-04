package framework.screens;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import framework.models.Item;
import org.openqa.selenium.By;

public class ItemScreen extends AndroidScreen{
    private final ILabel itemName = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvItemBrand"), "item name label");
    private final ILabel itemPrice = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvAdditionalOriginal"), "item price label");
    private final ILabel itemDiscount = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvAdditionalDiscount"), "item discount label");
    private final ILabel itemPriceWithDiscount = getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/tvAdditionalPrice"), "item price with discount label");
    private final IButton sellerButton = getElementFactory().getButton(By.id("com.zdv.secretcloset:id/rlSellerInfo"), "seller button");
    public ItemScreen() {
        super(By.id("com.zdv.secretcloset:id/rlBuyButton"), "Item screen");
    }

    public boolean isCorrectItemNameDisplayed(Item item) {
        AqualityServices.getLogger().info("Check that correct item name is displayed");
        return itemName.getAttribute("text").equals(item.getItemName());
    }

    public boolean isCorrectItemPriceWithDiscountDisplayed(Item item) {
        AqualityServices.getLogger().info("Check that correct item price with discount is displayed");
        return itemPriceWithDiscount.getAttribute("text").contains(item.getItemPriceWithDiscount());
    }

    public boolean isCorrectItemPriceDisplayed(Item item) {
        AqualityServices.getLogger().info("Check that correct item price is displayed");
        scrollToItemPriceLabel();
        return itemPrice.getAttribute("text").equals(item.getItemPrice());
    }

    public boolean isCorrectDiscountDisplayed(Item item) {
        AqualityServices.getLogger().info("Check that correct item discount is displayed");
        if (itemDiscount.getAttribute("text").equals(item.getItemDiscount())) {
            scrollToTheItemNameLabel();
            return true;
        } else {
            scrollToTheItemNameLabel();
            return false;
        }
    }

    public void scrollToItemPriceLabel() {
        AqualityServices.getLogger().info("Scroll to Item Price label");
        itemPrice.getTouchActions().scrollToElement(SwipeDirection.DOWN);
    }

    public void scrollToTheItemNameLabel() {
        AqualityServices.getLogger().info("Scroll to Item name Label");
        itemName.getTouchActions().scrollToElement(SwipeDirection.UP);
    }

    public void openSellerPage() {
        AqualityServices.getLogger().info("Click Seller icon");
        sellerButton.click();
    }
}
