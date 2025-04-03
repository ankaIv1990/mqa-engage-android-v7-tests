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
    public void clickGetAlias() throws InterruptedException {
        buttonGetAlias.click();
    }
    public static int randomNumber(){
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        return randomNumber;
    }
}
