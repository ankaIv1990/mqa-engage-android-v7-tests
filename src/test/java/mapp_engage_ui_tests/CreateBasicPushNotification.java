package mapp_engage_ui_tests;

import base.EngageTestBase;
import mapp_engage_ui_pages.StartPage;
import org.testng.annotations.Test;

public class CreateBasicPushNotification extends EngageTestBase {
    StartPage startPage;

    @Test
    public void createPushNotification() throws InterruptedException {
        startPage = new StartPage(driver);
        startPage.goToPushNotificationsPage();
    }
}
