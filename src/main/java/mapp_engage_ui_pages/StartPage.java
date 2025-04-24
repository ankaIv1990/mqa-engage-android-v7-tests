package mapp_engage_ui_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web_engage.WebTestBase;

public class StartPage extends WebTestBase {
    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#topNavElement")
    WebElement shadowRootNavigation;
    @FindBy(xpath = "//*[@id=\"2-nav-msg-push\"]")
    WebElement buttonPushNotifications;

    public void goToPushNotificationsPage() throws InterruptedException {
        SearchContext navMessages = shadowRootNavigation.getShadowRoot();
        navMessages.findElement(By.cssSelector("#nav-messages")).click();

        Thread.sleep(3000);

        SearchContext pushNotifications = shadowRootNavigation.getShadowRoot();
        pushNotifications.findElement(By.cssSelector("#\\32 -nav-msg-push")).click();
    }
}
