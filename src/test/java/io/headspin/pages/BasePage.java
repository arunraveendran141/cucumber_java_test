package io.headspin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static io.headspin.global_variables.GlobalVariable.*;

public class BasePage {

    public static WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    public static WebDriverWait LongWait = new WebDriverWait(driver, Duration.ofSeconds(30));


    /**
     * =========================================================================================
     * Function Name: waitForElementPresent
     * Description: This function is used to Wait till element is visible in the current page.
     * Usage: waitForElementAndClick(btn_login);
     * ===========================================================================================
     */

    public static boolean waitForElementPresent(By elementToWaitFor) {
        try
        {
            Wait.until(ExpectedConditions.presenceOfElementLocated(elementToWaitFor));
            return true;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            System.out.println("No Such Element Present");
            return false;
        }

    }

    /**
     * =========================================================================================
     * Function Name: waitForElementsPresent
     * Description: This function is used to Wait till All element is visible in the current page.
     * Usage: waitForElementsPresent(btn_element);
     * ===========================================================================================
     */

    public static List<WebElement> waitForElementsPresent(By elementToWaitFor) {
        List<WebElement> list_of_elements = null;
        try
        {
            list_of_elements = Wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementToWaitFor));
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            System.out.println("No Such Element Present");
        }
        return list_of_elements;

    }

    /**
     * =========================================================================================
     * Function Name: longWaitForElementPresent
     * Description: This function is used to Wait long till element is visible in the current page.
     * Usage: longWaitForElementPresent(btn_login);
     * ===========================================================================================
   */

    public static boolean longWaitForElementPresent(By elementToWaitFor) {
        try
        {
            LongWait.until(ExpectedConditions.presenceOfElementLocated(elementToWaitFor));
            return true;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            System.out.println("No Such Element Present");
            return false;
        }

    }

    /**=========================================================================================
     * Function Name: waitForElementPresentAndClick
     * Description: This function is used to Wait till element is visible in the current page.
     * Usage: waitForElementAndClick(btn_login);
     *===========================================================================================*/

    public static void waitForElementAndClick(By elementToWaitFor) {
        try
        {
            Wait.until(ExpectedConditions.presenceOfElementLocated(elementToWaitFor)).click();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            System.out.println("No Such Element Present");
        }
    }

    /**=========================================================================================
     * Function Name: waitForElementPresentAndSendKeys
     * Description: This function is used to Wait till element is visible in the current page.
     * Usage: waitForElementAndSendKeys(btn_login, "username");
     *===========================================================================================*/

    public static void waitForElementAndSendKeys(By elementToWaitFor, String message) {
        try
        {
            Wait.until(ExpectedConditions.presenceOfElementLocated(elementToWaitFor)).sendKeys(message);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            System.out.println("No Such Element Present");
        }
    }

    /**
     * =========================================================================================
     * Function Name: waitForElementPresentAndGetText
     * Description: This function is used to Wait till element is visible in the current page.
     * Usage: waitForElementAndGetText(txt_message);
     * ===========================================================================================
     */

    public static String waitForElementAndGetText(By elementToWaitFor) {
        String output_message = null;
        try
        {
            output_message = Wait.until(ExpectedConditions.presenceOfElementLocated(elementToWaitFor)).getText();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
            System.out.println("No Such Element Present");
        }
        return output_message;
    }

    /**=========================================================================================
     * Function Name: waitForElementPresentAndConfirmURL
     * Description: This function is used to Wait till element is visible in the current page.
     * Usage: waitForElementAndGetText(txt_message);
     *===========================================================================================*/

    public static void waitForElementPresentAndConfirmURL(String url) {
        try
        {
            Wait.until(ExpectedConditions.urlToBe(url));
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            System.out.println("URL Didn't Match");
        }
    }


    /**=========================================================================================
     * Function Name: waitForSpecificTime
     * Description: This function is used to Wait for user specified time interval.
     * Usage: waitForSpecificTime(5000);
     *===========================================================================================*/

    public static void waitForSpecificTime(long numOfSeconds) {
        try
        {
            Thread.sleep(numOfSeconds*1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            System.err.println("Exception caught while waiting for " + numOfSeconds + "seconds");
        }
    }

}
