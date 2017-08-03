package com.sportsdirect.automation.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = "com.sportsdirect.automation.steps",
        features = "src/test/resources/"
)
public class SportsDirectTest {
}
