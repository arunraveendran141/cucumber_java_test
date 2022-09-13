package io.headspin.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.headspin.pages.LaunchPage;
import io.headspin.pages.ResultPage;

public class SpeedTest {
    LaunchPage launchPage_obj = new LaunchPage();
    ResultPage resultPage_obj = new ResultPage();

    @Then("User enters launch page")
    public void userEntersLaunchPage() {
        launchPage_obj.verify_launch();

    }

    @When("User click on the go button")
    public void userClickOnTheGoButton() {
        launchPage_obj.click_btn_go();

    }

    @Then("User will get the test result")
    public void userWillGetTheTestResult() {
        resultPage_obj.verify_result();
    }
}
