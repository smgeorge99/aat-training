@VideoStore
Feature: Video Store Scenarios

Scenario: Regular customer rents SD movies for $1/day
Given a "regular" customer 
When the customer rents 1 "standard definition" movies for 4 days
Then the total rental charge should be "$4.00" 

Scenario: Regular customer rents HD movies for $3/day
Given a "regular" customer
When the customer rents 1 "high definition" movies for 3 days
Then the total rental charge should be "$9.00"

Scenario: Regular customer rents four SD movies and is only charged for three
Given a "regular" customer
When the customer rents 4 "standard definition" movies for 5 days
Then the total rental charge should be "$15.00"

Scenario: Regular customer rents four HD movies and is only charged for three
Given a "regular" customer
When the customer rents 4 "high definition" movies for 2 days
Then the total rental charge should be "$18.00"

Scenario: VIP customer gets 10% off SD movie rental
Given a "VIP" customer 
When the customer rents 1 "standard definition" movies for 4 days
Then the total rental charge should be "$3.60" 

Scenario: VIP customer gets 10% off HD movie rental
Given a "VIP" customer
When the customer rents 1 "high definition" movies for 3 days
Then the total rental charge should be "$8.10"

Scenario: VIP customer rents four SD movies and is only charged for three
Given a "VIP" customer
When the customer rents 4 "standard definition" movies for 5 days
Then the total rental charge should be "$13.50"

Scenario: VIP customer rents four HD movies and is only charged for three
Given a "VIP" customer
When the customer rents 4 "high definition" movies for 2 days
Then the total rental charge should be "$16.20"

Scenario: Regular customer rental charges stop accruing after 14 days
Given a "regular" customer
When the customer rents 1 "high definition" movies for 20 days
Then the total rental charge should be "$42.00"

Scenario: VIP customer rental charges stop accruing after 14 days
Given a "VIP" customer 
When the customer rents 1 "standard definition" movies for 30 days
Then the total rental charge should be "$12.60" 

Scenario: Regular Customer rental inquiry
Given a "regular" customer has three movies rented
When the rental store requests the customer's current rentals
Then the titles of the customer's current rentals should be displayed

Scenario: Regular Customer earns frequent renter points for SD movies
Given a "regular" customer 
When the customer rents 3 "standard definition" movies for 2 days
Then the frequent renter points should be 3

Scenario: Regular Customer earns frequent renter points for HD movies
Given a "regular" customer 
When the customer rents 2 "high definition" movies for 3 days
Then the frequent renter points should be 4

Scenario: VIP Customer earns frequent renter points for SD movies
Given a "VIP" customer 
When the customer rents 3 "standard definition" movies for 6 days
Then the frequent renter points should be 6

Scenario: VIP Customer earns frequent renter points for HD movies
Given a "VIP" customer 
When the customer rents 2 "high definition" movies for 5 days
Then the frequent renter points should be 8
