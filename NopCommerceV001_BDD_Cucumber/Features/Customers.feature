Feature: Customer

Background:Steps common for all scenario
	Given User launch chrome browser
	When User opens url "https://admin-demo.nopcommerce.com/login"
	And User enters email as "admin@yourstore.com" and password as "admin"
	And Click on Login 
	Then User can view Dashboard
	
@sanity
Scenario: Add New Customer
	When User click on customers menu
	And Click on customers Menu Item
	And Click on Add new button
	Then User can view Add new customer page
	When User enter customer information
	And click on Save button
	Then User can view confirmation message "The new customer has been added successfully"

@regression	
Scenario: Search Customer by email 
	When User click on customers menu
	And Click on customers Menu Item
	And User enter an email
	When click on seach button
	Then User should found Email in the search table

@regression
Scenario: Search Customer by name 
	When User click on customers menu
	And Click on customers Menu Item
	And User enter an First name
	And User enter an Last name
	When click on seach button
	Then User should found Name in the search table
