package framework.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

public class CitySearchScreen extends AndroidScreen {
    public CitySearchScreen() {
        super(By.id("com.zdv.secretcloset:id/tvTitle"), "Select city");
    }

    private ITextBox citySearch = getElementFactory().getTextBox(By.id("com.zdv.secretcloset:id/etSearchTest"), "Search city");

    public void searchAndSelectCity(String city) {
        AqualityServices.getLogger().info("Search city: " + city);
        citySearch.type(city);
        IButton cityButton = getElementFactory().getButton(By.xpath(String.format("//android.widget.TextView[@text='%s']", city)), "country button");
        AqualityServices.getLogger().info("Select city: " + city);
        cityButton.click();
    }
}
