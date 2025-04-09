package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.firefox.FirefoxOptions;

public class EngageTestBase {

    public WebDriver driver;
    String system;
    String url;
    String username;
    String password;
    String browser;

    public void loadPropertiesFile() {

        url = LocalProperties.getBaseUrl();
        username = LocalProperties.getUsername();
        password = LocalProperties.getPassword();
        system = "mac";
        browser = "chrome";

    }

    @BeforeTest
    public void setUp (){
        try {

            loadPropertiesFile();

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    this.driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    // Set Firefox binary location
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setBinary("/Applications/Firefox");
                    this.driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    this.driver = new EdgeDriver();
                    break;
            }

            driver.manage().window().maximize();
            driver.get(url);

            driver.findElement(By.id("loginUsername")).sendKeys(username);
            driver.findElement(By.id("loginPassword")).sendKeys(password);
            driver.findElement(By.cssSelector("#gotoStartPage > button")).click();
        }
        catch(Exception e){
            System.out.println("Failed to load properties file.");
            e.printStackTrace();
        }
    }

    @AfterTest
    public void quit() {
        driver.close();
    }

}
