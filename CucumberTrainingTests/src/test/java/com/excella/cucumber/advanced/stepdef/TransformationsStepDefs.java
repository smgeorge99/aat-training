package com.excella.cucumber.advanced.stepdef;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.excella.cucumber.hov.PoliceOfficer;
import com.excella.cucumber.hov.Vehicle;
import com.excella.cucumber.student.Student;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TransformationsStepDefs {

	private PoliceOfficer officer;
	private Student student;
	private List<String> planetsInOrder = new ArrayList<>();
	private String actualPreamble = "We the People of the United "
			+ "States, in Order to form a more perfect Union, "
			+ "establish Justice, insure domestic Tranquility, "
			+ "provide for the common defence, promote the general "
			+ "Welfare, and secure the Blessings of Liberty to "
			+ "ourselves and our Posterity, do ordain and establish "
			+ "this Constitution for the United States of America.";

	@Before
	public void initPlanetList() {
		System.out.println("initializing planets");
		planetsInOrder.add("Mercury");
		planetsInOrder.add("Venus");
		planetsInOrder.add("Earth");
		planetsInOrder.add("Mars");
		planetsInOrder.add("Jupiter");
		planetsInOrder.add("Saturn");
		planetsInOrder.add("Uranus");
		planetsInOrder.add("Neptune");
	}

	@After
	public void resetVariables() {
		System.out.println("resetting variables");
		officer = null;
		planetsInOrder.clear();
	}

	@Given("^I am a police officer$")
	public void i_am_a_police_officer() throws Throwable {
		officer = new PoliceOfficer();
	}

	@When("^I see the following vehicles in the HOV-3 lanes$")
	public void i_see_the_following_vehicles_in_the_HOV_lanes(
			List<Vehicle> observedVehilces) throws Throwable {
		officer.setObservedVehicles(observedVehilces);
	}

	@Then("^I will not issue a ticket for an HOV-3 violation$")
	public void i_will_not_issue_a_ticket_for_an_HOV_violation()
			throws Throwable {
		for (Vehicle vehicle : officer.getObservedVehicles()) {
			assertTrue(vehicle.isHOV3Eligible());
		}
	}

	@Given("^I am a student$")
	public void i_am_a_student() throws Throwable {
		student = new Student();
	}

	@When("^I am asked to name the planets in the solar system$")
	public void i_am_asked_to_name_the_planets_in_the_solar_system() {
		student.setScienceAnswer(planetsInOrder);
	}

	@Then("^I will answer the science question correctly$")
	public void i_will_correctly_answer(List<String> expectedAnswer) throws Throwable {
		assertEquals(expectedAnswer, student.getScienceAnswer());
	}

	@When("^I am asked to recite the Preamble to the US Constitution$")
	public void i_am_asked_to_recite_the_Preamble_to_the_US_Constitution() {
		student.setCivicsAnswer(actualPreamble);
	}

	@Then("^I will answer the civics question correctly$")
	public void i_will_correctly_answer(String expectedAnswer) throws Throwable {
		assertEquals(expectedAnswer, student.getCivicsAnswer());
	}

}
