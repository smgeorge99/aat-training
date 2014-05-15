package com.excella.cucumber.videostore.stepdef;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.excella.javafortesters.videostore.Customer;
import com.excella.javafortesters.videostore.HDMovie;
import com.excella.javafortesters.videostore.Movie;
import com.excella.javafortesters.videostore.RegularCustomer;
import com.excella.javafortesters.videostore.Rental;
import com.excella.javafortesters.videostore.SDMovie;
import com.excella.javafortesters.videostore.VIPCustomer;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VideoStoreStepDefs {
	
	private Customer currentCustomer;
	private Rental currentRental;
	
	@Before
	public void clearData() {
		currentCustomer = null;
		currentRental = null;
	}

	@Given("^a \"(.*?)\" customer$")
	public void a_customer(String customerType) throws Throwable {
	    createCustomer(customerType);
	}

	private void createCustomer(String customerType) {
		switch (customerType) {
		case "regular":
			currentCustomer = new RegularCustomer(customerType);
			break;
		case "VIP":
			currentCustomer = new VIPCustomer(customerType);
			break;
		default:
			fail("Unsupported customer type");
			break;
		}
	}
	
	@When("^the customer rents (\\d+) \"(.*?)\" movies for (\\d+) days$")
	public void the_customer_rents_movies_for_days(int numMovies, String movieType, int numDaysRented) throws Throwable {
		currentRental = new Rental(currentCustomer);
		
		for (int i = 0; i < numMovies; i++) {
			currentRental.addMovie(createMovie(movieType, "Movie Title" + (i+1)));
		}
		
		currentRental.setDaysRented(numDaysRented);
	}

	private Movie createMovie(String movieType, String title) {
		Movie movie = null;
		
		switch (movieType) {
		case "standard definition":
			movie = new SDMovie(title);
			break;
		case "high definition":
			movie = new HDMovie(title);
			break;
		default:
			fail("Unsupported movie type");
			break;
		}
		return movie;
	}
	
	@Then("^the total rental charge should be \"(.*?)\"$")
	public void the_total_rental_charge_should_be(String expectedRentalCharge) throws Throwable {
		assertEquals(convertExpectedChargeToBigDecimal(expectedRentalCharge), currentRental.getTotalCharge());
	}
	
	private BigDecimal convertExpectedChargeToBigDecimal(String expectedCharge) {
		String strippedCharge = StringUtils.remove(expectedCharge, "$");
		return new BigDecimal(strippedCharge);
	}

	@Given("^a \"(.*?)\" customer has three movies rented$")
	public void a_customer_has_three_movies_rented(String customerType) throws Throwable {
	    createCustomer(customerType);
	    currentRental = new Rental(currentCustomer);
		
		for (int i = 0; i < 3; i++) {
			currentRental.addMovie(createMovie("standard definition", "Movie Title" + (i+1)));
		}
	}

	@When("^the rental store requests the customer's current rentals$")
	public void the_rental_store_requests_the_customer_s_current_rentals() throws Throwable {
	    //nothing to actually do here
	}

	@Then("^the titles of the customer's current rentals should be displayed$")
	public void the_titles_of_the_customer_s_current_rentals_should_be_displayed() throws Throwable {
	    assertEquals("Movie Title1, Movie Title2, Movie Title3", currentRental.getMovieTitles());
	}

	@Then("^the frequent renter points should be (\\d+)$")
	public void the_frequent_renter_points_should_be(int expectedNumPoints) throws Throwable {
	    assertEquals(expectedNumPoints, currentRental.getFrequentRenterPoints());
	}
}
