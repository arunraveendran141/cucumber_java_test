package io.headspin.utils;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

@Test
public class MavenParameters {
    public static String webdriver_url = System.getProperty("appiumInput","False");
    public static String selector = System.getProperty("selector","False");
    public static URL url;

    static {
        
        try {
            url = new URL(webdriver_url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String UDID  = System.getProperty("udid","False");
}
