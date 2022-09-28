package io.headspin.utils;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

@Test
public class MavenParameters {
    public static String webdriver_url = System.getProperty("appiumInput","https://dev-in-blr-0.headspin.io:7020/v0/a039649c32eb406ea479a93941a1de37/wd/hub");
    public static String load_balancer_url = System.getProperty("appiumInput","https://dev-in-blr-0.headspin.io:7020/v0/a039649c32eb406ea479a93941a1de37/wd/hub");
    public static String selector = System.getProperty("selector","device_id:4cb02cfb");
    public static URL url;

    static {
        
        try {
            if (selector != "device_id:4cb02cfb"){
                url = new URL(webdriver_url);
            }else{
                url = new URL(load_balancer_url);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String UDID  = System.getProperty("udid","4cb02cfb");
}
