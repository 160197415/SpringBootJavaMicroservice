package com.tsi.abbas.gure.program;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
                features = "src/test/resources/Cucumber.feature",
                glue = "com.tsi.abbas.gure.program")



    public class runCucumberTest {



}
