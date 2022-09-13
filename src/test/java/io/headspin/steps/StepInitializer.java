package io.headspin.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;
import java.net.URISyntaxException;

import static io.headspin.global_variables.GlobalVariable.*;
import static io.headspin.utils.BaseInitializer.getDriver;
import static io.headspin.utils.SessionVisualLib.*;

public class StepInitializer {

    @Before
    public void set_up() throws IOException, URISyntaxException, InterruptedException {
        if(driver == null || driver.toString().contains("null")) {
            driver = getDriver();
        }
        System.out.println("driver created ->");
//        Appium_Driver.launchApp();


    }
    @After
    public void tear_down()throws IOException, URISyntaxException, InterruptedException {
        if (null != driver)
        {
            driver.quit();
        }
        run_record_session_info();
    }
}
