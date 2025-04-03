package android_sample_java_app_tests;

import android_app_pages.BaseTestsPage;
import android_app_pages.HomeScreen;
import base.AndroidTestBase;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GetAlias extends AndroidTestBase {
    HomeScreen homeScreen;
    BaseTestsPage baseTestsPage;

    @Test
    public void getAliasTest() throws Exception {
        homeScreen = new HomeScreen(driver);
        baseTestsPage = new BaseTestsPage(driver);
        homeScreen.clickButtonBaseTests();

        baseTestsPage.textSetAlias();
        String actualPopUpText = String.valueOf(driver.findElement(By.id("com.appoxee.example:id/editTextAlias")).getText());
        System.out.println(actualPopUpText);

        baseTestsPage.clickSetAlias();
        Thread.sleep(5000);
        driver.findElement(By.id("android:id/button1")).click();

        baseTestsPage.clickGetAlias();
        Thread.sleep(5000);

        String expectedPopUpText = String.valueOf(driver.findElement(By.id("android:id/message")).getText());
        System.out.println(expectedPopUpText);

        Assert.assertEquals(actualPopUpText, expectedPopUpText);
    }
}
