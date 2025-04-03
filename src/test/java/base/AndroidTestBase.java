package base;

import com.fasterxml.jackson.databind.JsonNode;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.xml.XmlTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AndroidTestBase {

    Logger logger = Logger.getLogger(AndroidTestBase.class.getName());

    public static AndroidDriver driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeMethod
    public void setUp(@Optional("emulator") String device) throws MalformedURLException {

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "resources/");
        File app = new File(appDir, "sample-java-app-debug.apk");

        if ("perfecto".equals(System.getProperty("cloud"))) {
            UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
            logger.info("Setting up perfecto capabilities");

            uiAutomator2Options.setCapability("platformName", "android");

            // The below capability is mandatory. Please do not replace it.
            String securityToken = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJmYWViZGM1ZS1lNjNiLTRhYmUtODk4ZC02ODI5YzllOTI3ZTcifQ.eyJpYXQiOjE2MzQ4NzAyMTMsImp0aSI6ImU0NjYwMGJlLTA1ZmYtNDZkMi1iNTE5LTM2MjJjMTEyYTcyZSIsImlzcyI6Imh0dHBzOi8vYXV0aDUucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL21hcHBkaWdpdGFsLXBlcmZlY3RvbW9iaWxlLWNvbSIsImF1ZCI6Imh0dHBzOi8vYXV0aDUucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL21hcHBkaWdpdGFsLXBlcmZlY3RvbW9iaWxlLWNvbSIsInN1YiI6ImQwMjE1OWE3LTEzNGYtNGY0OC1hZjI2LWYwMTQzMDJmYTQ5ZiIsInR5cCI6Ik9mZmxpbmUiLCJhenAiOiJvZmZsaW5lLXRva2VuLWdlbmVyYXRvciIsIm5vbmNlIjoiZDU1ZGZkNzQtZjZmOS00OGNkLThmODktN2I2MzAwYzhjNzg0Iiwic2Vzc2lvbl9zdGF0ZSI6IjIwMjc0M2QzLTdjZTctNDdiNi1hMjQ2LWY0YTk2OTU4ODI5NiIsInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIHByb2ZpbGUgZW1haWwifQ.DCG3U5I9it35kPJ16NvqC_phMbfxkkIG9-yLeT6wrpk";

            HashMap<String, Object> perfectoOptions = new HashMap<>();
            perfectoOptions.put("securityToken", securityToken);
            perfectoOptions.put("enableAppiumBehavior", true);
            perfectoOptions.put("openDeviceTimeout", 5);
            perfectoOptions.put("app", "PRIVATE:Mapp-Intelligence-native.apk"); // Set Perfecto Media repository path of App under test.
            perfectoOptions.put("appPackage", "com.mapp.sdk.android"); // Set the unique identifier of your app
            perfectoOptions.put("autoLaunch", true); // Whether to install and launch the app automatically.
            perfectoOptions.put("takesScreenshot", false);
            perfectoOptions.put("screenshotOnError", true); // Take screenshot only on errors
            perfectoOptions.put("waitForAvailableLicense", true);
            uiAutomator2Options.setCapability("perfecto:options", perfectoOptions);

            driver = new AndroidDriver(new URL("https://mappdigital.perfectomobile.com/nexperience/perfectomobile/wd/hub"), uiAutomator2Options);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } else
        if ("lambdatest".equals(System.getProperty("cloud"))) {
            logger.info("Setting up lambdatest capabilities");
            String userName = "smoketests";
            String accessKey = "rnIziDZgB6NxHxYCl5UMAcegwJTBmUORliGUk40GF6lSxTnGox";

            String gridURL = "@mobile-hub.lambdatest.com/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();

            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("build","Java TestNG Android Native " +
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            ltOptions.put("name","Android Native");
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("isRealMobile", true);
            ltOptions.put("app", "lt://APP10160602371727357405355193");
            ltOptions.put("console", true);
            ltOptions.put("network", true);
            ltOptions.put("visual", true);
            ltOptions.put("devicelog", true);
            capabilities.setCapability("lt:options", ltOptions);

            String hub = "https://" + userName + ":" + accessKey + gridURL;
            driver = new AndroidDriver(new URL(hub), capabilities);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } else {

            if (device.contains("real"))
            {
                logger.info("Setting up real device capabilities");
                capabilities.setCapability("automationName", "UiAutomator2");
                capabilities.setCapability("appium:platformName", MobilePlatform.ANDROID);
                capabilities.setCapability("platformVersion", "9.0");
                capabilities.setCapability("udid", "9WVDU18514000334");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("appPackage", "com.example.webtrekk.androidsdk");
                capabilities.setCapability("appActivity", ".MainActivity");

                final String urlString = "http://localhost:4723";
                URL url = new URL(urlString);

                driver = new AndroidDriver(url, capabilities);
                driver.setLogLevel(Level.INFO);
            } else {
                //Emulator:launch emulator directly
                logger.info("Setting up emulator capabilities");
                capabilities.setCapability("newCommandTimeout", 1000);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android 11");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                capabilities.setCapability("avd", "Android_11");
                capabilities.setCapability("avdLaunchTimeout", 180000);
                capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

                final String urlString = "http://0.0.0.0:4723";
                URL url = new URL(urlString);

                driver = new AndroidDriver(url, capabilities);
                driver.setLogLevel(Level.INFO);
            }
        }

    }

    @BeforeTest
    public void beforeTest(ITestContext iTestContext, XmlTest xmlTest) {

        System.out.println("**********************************************************************************************");
        System.out.println("Test name: " + iTestContext.getName() + " Test Case execution !!!");
        System.out.println("**********************************************************************************************");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
