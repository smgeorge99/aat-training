package com.excella.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	format={"html:build/cucumber.html", "junit:build/cucumber.xml","json:build/cucumber.json"}
	, glue={"com.excella.cucumber.basic.stepdef"}
	, features={"src/test/resources/com/excella/cucumber/basic"}
		)
public class CucumberBasicRunner {

}
