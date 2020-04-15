Feature: Customers

Background: Below are common steps for every scanario
 	Given User Launch Chrome browser
	When User Opens URL "https://admin-demo.nopcommerce.com/login"
	And User Enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can view Dashboard
	
@sanity
Scenario: Add New Customer	
	When User Click on Customers Menu
	And Click on Customers Menu Item
	And Click on Add New Button
	Then User can view Add new cusotmer page
	When User enter cusotmer info
	And Click on Save button
	Then User can view confirmation message "Then new customer has been added successfully."
	And Close Browser

@regression
Scenario: Search Customer by EMailID
	When User Click on Customers Menu
	And Click on Customers Menu Item
	And Enter Customer Email
	When Click on Search Button
	Then User Should found Email in the Search table
	And Close Browser
	