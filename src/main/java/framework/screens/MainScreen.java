package framework.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import org.openqa.selenium.By;


public class MainScreen extends AndroidScreen {

    private final IButton cityButton = getElementFactory().getButton(By.id("com.zdv.secretcloset:id/tvToolbarCity"), "city button");
    private final IButton firstItemButton = getElementFactory().getButton(By.xpath("//android.widget.RelativeLayout[@index='0' and @resource-id='com.zdv.secretcloset:id/rlBanner']"), "first item button");

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
}
