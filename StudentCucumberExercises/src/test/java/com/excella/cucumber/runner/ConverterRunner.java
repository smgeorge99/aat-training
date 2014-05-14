package com.excella.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	format={"html:build/cucumber.html", "junit:build/cucumber.xml","json:build/cucumber.json"}
	, features={"src/test/resources/com/excella/cucumber/converter"}
		)
public class ConverterRunner {

}
