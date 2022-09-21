package io.headspin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ResultPage extends BasePage {

    /*Initialize Element Locators Here*/
    public static By txt_test_again = By.id("org.zwanoo.android.speedtest:id/suite_completed_feedback_assembly_test_again");
    public static By txt_result = By.id("org.zwanoo.android.speedtest:id/txt_test_result_value");

    public void verify_result() {
        longWaitForElementPresent(txt_test_again);

        List<WebElement> list_of_elements = waitForElementsPresent(txt_result);
        System.out.println("Download Speed:" + list_of_elements.get(0).getText());
        /*System.out.println("Upload Speed:" + list_of_elements.get(1).getText());
        System.out.println("Ping:" + list_of_elements.get(2).getText());
        System.out.println("Jitter:" + list_of_elements.get(3).getText());
        System.out.println("Loss:" + list_of_elements.get(4).getText());*/

      /*int num = list_of_elements.size();
        for(int i=0; i<num; i++){
             System.out.println(list_of_elements.get(i).getText());

        }*/
    }
}
