package mapp_engage_ui_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web_engage.WebTestBase;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Random;

public class PushNotificationsPage extends WebTestBase {
    public PushNotificationsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = "div.mui-page-header-actions > div > a")
    WebElement buttonCreateMessagePush;
    @FindBy (css = "#mat-input-6")
    WebElement inputNameInfo;
    @FindBy (xpath = "//mat-label[@class='ng-tns-c3736059725-66']")
    WebElement inputDescriptionInfo;
    @FindBy (xpath = "//span[normalize-space()='Next >']")
    WebElement buttonNextInfo;
    @FindBy (xpath = "//div[@class='mat-mdc-select-arrow ng-tns-c1771602899-153']//*[name()='svg']")
    WebElement dropDownAppName;
    @FindBy (xpath = "/html/body/app-root/main/app-push/div/div/mat-card/form/mui-stepper/mui-step[2]/div/app-push-step2/div/div[2]/mat-accordion/mat-expansion-panel[2]")
    WebElement buttonContent;
    @FindBy (css = "#cdk-accordion-child-1 > div > fieldset:nth-child(1) > ngx-monaco-editor > div")
    WebElement inputTitle;
    @FindBy (css = "#cdk-accordion-child-1 > div > fieldset:nth-child(2) > ngx-monaco-editor > div > div > div.overflow-guard > div.monaco-scrollable-element.editor-scrollable.vs.mac > div.lines-content.monaco-editor-background > div.view-lines.monaco-mouse-cursor-text")
    WebElement inputMessageBody;
    @FindBy (css = "button.mdc-button.mdc-button--raised.mat-mdc-raised-button.mat-primary.mat-mdc-button-base.ng-star-inserted")
    WebElement buttonNextCompose;
    @FindBy (css = "")
    WebElement buttonNextDelivery;
    @FindBy (css = "")
    WebElement buttonSave;
    @FindBy (css = "")
    WebElement buttonSend;

    public void createBasicPushNotification() throws InterruptedException {
        buttonCreateMessagePush.click();
        inputNameInfo.sendKeys("Automation_Test_Basic_Push_Sendout_" + randomNumber());
        buttonNextInfo.click();
        Thread.sleep(2000);
        //dropDownAppName.click();
        buttonContent.click();
        Thread.sleep(2000);
        //Scroll down method
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        inputTitle.sendKeys("Automation Test");
        inputMessageBody.sendKeys("Testing via Automated tests.");
        buttonNextCompose.click();
    }

    public static int randomNumber(){
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        return randomNumber;
    }


}
