package io.headspin.pages;
import org.openqa.selenium.By;

public class LaunchPage extends BasePage {

    /*Initialize Element Locators Here*/
    public static By btn_go= By.id("org.zwanoo.android.speedtest:id/go_button");

    public void verify_launch() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(btn_go));
        waitForElementPresent(btn_go);
        System.out.println("Launch Page Verified");
    }

    public void click_btn_go() {
        waitForElementAndClick(btn_go);
        System.out.println("speed test started");
    }
}
