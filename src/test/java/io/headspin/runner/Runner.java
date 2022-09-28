package io.headspin.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/resources/features",
        glue = "io.headspin.steps",
        tags = "@SpeedTest" )

@Test
public class Runner extends AbstractTestNGCucumberTests {

}
