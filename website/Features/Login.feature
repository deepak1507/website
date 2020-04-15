Feature: Login

@sanity @regression
Scenario: Successful Login with Valid Credentials
	Given User Launch Chrome browser
	When User Opens URL "https://admin-demo.nopcommerce.com/login"
	And User Enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then Page Title Should be "Dashboard / nopCommerce administration"
	When User Click on Log Out Link
	Then Page Title Should be "Your store. Login"
	And Close Browser

@sanity	
Scenario Outline: Login Data Driven
	Given User Launch Chrome browser
	When User Opens URL "https://admin-demo.nopcommerce.com/login"
	And User Enters Email as "<email>" and Password as "<password>"
	And Click on Login
	Then Page Title Should be "Dashboard / nopCommerce administration"
	When User Click on Log Out Link
	Then Page Title Should be "Your store. Login"
	And Close Browser
	
	Examples:
		| email | password |
		| admin@yourstore.com | admin |
		| admin@yourstore.com | admin123 |
		