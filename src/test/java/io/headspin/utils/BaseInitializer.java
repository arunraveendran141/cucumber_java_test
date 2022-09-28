package io.headspin.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static io.headspin.basic_functionalities.PropertyFileReader.getConfigProperty;
import static io.headspin.global_variables.GlobalVariable.*;

public class BaseInitializer{

    public static AppiumDriver driver;

    public static AppiumDriver getDriver() throws MalformedURLException {

        /*String UDID = getConfigProperty("Udid");
        URL url = new URL(getConfigProperty("AppiumURL"));*/
        String AppPackage = getConfigProperty("Package");
        String AppActivity = getConfigProperty("Activity");
        test_name = getConfigProperty("Test_name");


        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "Android");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability("appPackage", AppPackage);
        cap.setCapability("appActivity", AppActivity);
        cap.setCapability("headspin:controlLock", false);
        cap.setCapability("headspin:capture.video", true);
        cap.setCapability("autoLaunch", "true");
        cap.setCapability(MobileCapabilityType.NO_RESET, "true");

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, MavenParameters.UDID);
        cap.setCapability(MobileCapabilityType.UDID, MavenParameters.UDID);

        String url = MavenParameters.url.toString();
//        System.out.println(url);
        String[] url_array = url.split("/");
        access_token = url_array[url_array.length-3];
        System.out.println("Starting Driver");
        driver = new AppiumDriver(MavenParameters.url, cap);
        session_id = driver.getSessionId();
        return driver;
    }
}
