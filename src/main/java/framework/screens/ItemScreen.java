package framework.screens;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
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

    public boolean isCorrectItemOpened(String mainScreenName, String mainScreenPrice, String mainScreenDiscount, String mainScreenPriceWithDiscount) {
        AqualityServices.getLogger().info("Check that correct item is opened");
        boolean check = false;
        if (itemName.getAttribute("text").equals(mainScreenName)
                &&itemPriceWithDiscount.getAttribute("text").contains(mainScreenPriceWithDiscount)) {
            scrollToItemPriceLabel();
            if (itemPrice.getAttribute("text").equals(mainScreenPrice)
            && itemDiscount.getAttribute("text").equals(mainScreenDiscount)) {
                check = true;
            }
        } else {
            check = false;
        }
        scrollToTheItemNameLabel();
        return check;
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
