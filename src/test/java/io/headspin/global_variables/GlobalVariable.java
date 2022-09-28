package io.headspin.global_variables;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Dictionary;

public class GlobalVariable {
    public static AppiumDriver driver;
    public static String access_token;
    public static SessionId session_id;
    public static String test_name;
//    public static Dictionary session_specific_data;
}
