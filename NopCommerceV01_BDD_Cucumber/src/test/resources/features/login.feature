Feature:Login 

Background:
	Given User opens url "https://admin-demo.nopcommerce.com/login"

Scenario: Successful Login with valid credentials
	Given User enters email as "admin@yourstore.com" and password as "admin"
	When Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on logout link
	Then Page Title should be "nopCommerce demo store. Login"
	And close browser
	
Scenario Outline:
	Given User enters invalid "<email>" and "<password>"
	When Click on Login
	Then user should seen an error message indicating "<error_message>"
	
	Examples:
	|email 	                |password    | error_message
	|admins@yourstore.com 	|password1   | Warning: Invalid Credentials
	|admins@yourstore.com 	|password    | Warning: Invalid Credentials
	|admin@yourstore.com 	|passwords   | Warning: Invalid Credentials

Scenario: Navigating to the forgotton password page
	When user click on "forgotten password" link
	Then User should be redirect to the password reset page
