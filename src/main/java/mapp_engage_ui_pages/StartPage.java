package mapp_engage_ui_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web_engage.WebTestBase;

public class StartPage extends WebTestBase {
    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#nav-messages > span.mdc-button__label > span:nth-child(1)")
    WebElement buttonMessages;
    @FindBy(xpath = "//*[@id=\"2-nav-msg-push\"]")
    WebElement buttonPushNotifications;

    public void goToPushNotificationsPage(){
        buttonMessages.click();
        buttonPushNotifications.click();
    }
}
