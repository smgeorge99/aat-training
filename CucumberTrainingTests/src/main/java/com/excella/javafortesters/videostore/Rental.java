package com.excella.javafortesters.videostore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Rental {

	private static final int MAX_DAYS_TO_CHARGE = 14;
	
	private Customer customer;
	private List<Movie> movies;
	private int daysRented;
	
	public Rental(Customer customer)
	{
		this.setCustomer(customer);
		this.setMovies(new ArrayList<Movie>());
	}

	public void addMovie(Movie movie) {
		this.movies.add(movie);
	}

	public void setDaysRented(int days) {
		this.daysRented = days;		
	}
	
	public BigDecimal getTotalCharge() {
		
		BigDecimal totalCharge = new BigDecimal("0.00");
		BigDecimal days = new BigDecimal(this.daysRented);
		
		int chargedMovCount = 0; 
		
		for (Movie movie : this.getMovies())
		{
			if (chargedMovCount < 3)
			{
				totalCharge = totalCharge.add(this.calculateCharge(movie, days, this.customer.getDiscountRate()));
				chargedMovCount++;
			}
			else
			{
				chargedMovCount = 0;
			}
		}
		
		return totalCharge;
	}	

	private BigDecimal calculateCharge(Movie movie, BigDecimal days, BigDecimal discountRate) {
		
		BigDecimal actualDaysToCharge = days;
		
		if (days.intValue() > MAX_DAYS_TO_CHARGE)
		{
			actualDaysToCharge = new BigDecimal(MAX_DAYS_TO_CHARGE);
		}
		
		BigDecimal charge = movie.getDailyCharge().multiply(actualDaysToCharge);
		BigDecimal discount = charge.multiply(discountRate);
		
		return charge.subtract(discount).setScale(2);
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getMovieTitles() {
		
		String titles = "";
		
		int lastMovieIndex = 0;
		
		if (!this.getMovies().isEmpty())
		{
			lastMovieIndex = this.getMovies().size() -1;
		}
		
		for (Movie movie : this.getMovies())
		{
			titles += movie.getTitle();
			
			if (this.getMovies().indexOf(movie) < lastMovieIndex)
			{
				titles = titles + ", ";
			}
		}
		
		return titles;
	}

	public int getFrequentRenterPoints() {
		
		int totalPoints = 0;
		
		for (Movie movie : this.getMovies())
		{
			totalPoints += movie.getFrequentRenterPoint(); 
		}
		
		return totalPoints * this.customer.getPointMultiplier();
	}

}

