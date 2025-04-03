package android_app_pages;

import android_engage.MobileTestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends MobileTestBase {
    public HomeScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    //Elements
    @AndroidFindBy(id = "com.appoxee.example:id/btnBaseTests")
    WebElement buttonBaseTests;
    @AndroidFindBy(id = "com.appoxee.example:id/btnNotificationTests")
    WebElement buttonNotificationsTests;


    //Methods
    public void clickButtonBaseTests(){
        buttonBaseTests.click();
    }
    public void clickButtonNotificationsTests(){
        buttonNotificationsTests.click();
    }
}
