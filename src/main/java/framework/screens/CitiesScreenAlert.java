package framework.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import org.openqa.selenium.By;

public class CitiesScreenAlert extends AndroidScreen {
    private IButton okButton = getElementFactory().getButton(By.id("android:id/button1"), "city button");

    public CitiesScreenAlert() {
        super(By.id("android:id/alertTitle"), "Please do not forget alert");
    }

    public void clickOkButton() {
        AqualityServices.getLogger().info("Confirm alert message");
        okButton.click();
    }
}
