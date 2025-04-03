package web_engage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebTestBase {

    public WebDriver driver;

    public WebTestBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
