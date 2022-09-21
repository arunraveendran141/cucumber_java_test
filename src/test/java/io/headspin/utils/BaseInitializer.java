package io.headspin.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static io.headspin.basic_functionalities.PropertyFileReader.getConfigProperty;
import static io.headspin.global_variables.GlobalVariable.*;

public class BaseInitializer {

    public static AppiumDriver driver;

    public static AppiumDriver getDriver() throws MalformedURLException {

        String UDID = getConfigProperty("Udid");
        String AppPackage = getConfigProperty("Package");
        String AppActivity = getConfigProperty("Activity");
        test_name = getConfigProperty("Test_name");

        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "Android");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-M317F");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability(MobileCapabilityType.UDID, UDID);
        cap.setCapability("appPackage", AppPackage);
        cap.setCapability("appActivity", AppActivity);
        /*cap.setCapability(MobileCapabilityType.UDID, "RZ8NA0Z723M");
        cap.setCapability("appPackage", "org.zwanoo.android.speedtest");
        cap.setCapability("appActivity", "com.ookla.mobile4.screens.main.MainActivity");*/
        cap.setCapability("headspin:controlLock", false);
        cap.setCapability("headspin:capture.video", true);
        cap.setCapability("autoLaunch", "true");
        cap.setCapability(MobileCapabilityType.NO_RESET, "true");


//        URL url = new URL("https://dev-in-blr-0.headspin.io:3012/v0/a039649c32eb406ea479a93941a1de37/wd/hub");
        URL url = new URL(getConfigProperty("AppiumURL"));
        String[] url_array = getConfigProperty("AppiumURL").split("/");
        access_token = url_array[url_array.length-3];
        System.out.println("Starting Driver");
        driver = new AppiumDriver(url, cap);
        session_id = driver.getSessionId();
        return driver;
    }
}
