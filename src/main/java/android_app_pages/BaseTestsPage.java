package android_app_pages;

import android_engage.MobileTestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class BaseTestsPage extends MobileTestBase {
    public BaseTestsPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    //Elements
    @AndroidFindBy(id = "com.appoxee.example:id/switchPushEnabled")
    WebElement switchPushEnabled;
    @AndroidFindBy(id = "com.appoxee.example:id/editTextAlias")
    WebElement textSetAlias;
    @AndroidFindBy(id = "com.appoxee.example:id/btnSetAlias")
    WebElement buttonSetAlias;
    @AndroidFindBy(id = "com.appoxee.example:id/btnGetAlias")
    WebElement buttonGetAlias;
    @AndroidFindBy (id = "com.appoxee.example:id/btnGetDevice")
    WebElement buttonGetDevice;
    @AndroidFindBy (id = "com.appoxee.example:id/btnGetFbToken")
    WebElement buttonGetFirebaseToken;
    @AndroidFindBy (id = "com.appoxee.example:id/btnFetchInboxMessages")
    WebElement buttonFetchInboxMessages;
    @AndroidFindBy (id = "com.appoxee.example:id/btnFetchInappMessages")
    WebElement buttonFetchInAppMessages;
    @AndroidFindBy (id = "com.appoxee.example:id/btnSetCustomAttributes")
    WebElement buttonSetCustomAttributes;
    @AndroidFindBy (id = "com.appoxee.example:id/btnGetCustomAttributes")
    WebElement buttonGetCustomAttributes;
    @AndroidFindBy (id = "com.appoxee.example:id/btnStartGeofencing")
    WebElement buttonStartGeofencing;
    @AndroidFindBy (id = "com.appoxee.example:id/btnStopGeofencing")
    WebElement buttonStopGeofencing;


    //Methods
    public void switchPushEnabled(){
        switchPushEnabled.click();
    }
    public void textSetAlias(){
        textSetAlias.sendKeys("test_android_v7_automation" + randomNumber() + "@tests.com");
    }
    public void clickSetAlias(){
        buttonSetAlias.click();
    }
    public void clickGetAlias(){
        buttonGetAlias.click();
    }
    public void clickGetDevice(){
        buttonGetDevice.click();
    }
    public void clickGetFirebaseToken(){
        buttonGetFirebaseToken.click();
    }
    public void clickFetchInboxMessages(){
        buttonFetchInboxMessages.click();
    }
    public void clickFetchInAppMessages(){
        buttonFetchInAppMessages.click();
    }
    public void textSetCustomAttributes(){
        buttonSetCustomAttributes.click();
    }
    public void clickGetCustomAttributes(){
        buttonGetCustomAttributes.click();
    }
    public void clickStartGeofencing(){
        buttonStartGeofencing.click();
    }
    public void clickStopGeofencing(){
        buttonStopGeofencing.click();
    }

    public static int randomNumber(){
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        return randomNumber;
    }
}
