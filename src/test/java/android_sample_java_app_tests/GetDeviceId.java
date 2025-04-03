package android_sample_java_app_tests;

import android_app_pages.BaseTestsPage;
import android_app_pages.HomeScreen;
import base.AndroidTestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GetDeviceId extends AndroidTestBase {
    HomeScreen homeScreen;
    BaseTestsPage baseTestsPage;

    @Test
    public void getDeviceIdTest() throws InterruptedException {
        homeScreen = new HomeScreen(driver);
        baseTestsPage = new BaseTestsPage(driver);
        homeScreen.clickButtonBaseTests();
        baseTestsPage.clickGetDevice();
        Thread.sleep(5000);
    }
}
