package com.mhe.salesforce.login;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "json:target/cucumber.json",
                  "pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
                  "junit:target/cucumber-results.xml", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/test/resources/com/mhe/salesforce"},
        glue = {"com.mhe.salesforce"},
        tags = ("@login or @logout"))

public class TestRunner
{}