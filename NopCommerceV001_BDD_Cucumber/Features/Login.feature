Feature:Login

@sanity @regression
Scenario: Successful Login with valid credentials
	Given User launch chrome browser
	When User opens url "https://admin-demo.nopcommerce.com/login"
	And User enters email as "admin@yourstore.com" and password as "admin"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on logout link
	Then Page Title should be "nopCommerce demo store. Login"
	
@regression	
Scenario Outline:Successful Login with valid credentials DDT
	Given User launch chrome browser
	When User opens url "https://admin-demo.nopcommerce.com/login"
	And User enters email as "<email>" and password as "<password>"
	And Click on Login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on logout link
	Then Page Title should be "nopCommerce demo store. Login"
	
	Examples:
	|email 	                |password    
	|admins@yourstore.com 	|password1   
	|admins@yourstore.com 	|password    
	|admin@yourstore.com 	|passwords   
	|admin@yourstore.com    |admin