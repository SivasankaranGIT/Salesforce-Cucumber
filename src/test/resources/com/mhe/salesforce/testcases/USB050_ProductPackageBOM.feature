#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: View package definitions BOMs linked to an individual product from the Product Detail page

Background: 
	Given I am logged into salesforce for "ProductPackageBOM" 
	
	
@Products
@ProductPackageBOM @GCRM-9220
Scenario Outline: View package definitions BOMs linked to an individual product from the Product Detail page

	Given Runmode for "ProductPackageBOM" is Y
#	Then I login as Sales Rep
	Then I do login as "<SEG_Sales_Rep>"
	And I change the app launcher to Salesforce Chatter
	When Navigate to Products from App Launcher
	Then global search for product
	Then Verify packages and components
	Then global search for products
	And View package definitions BOMs

	Examples:
	|SEG_Sales_Rep|
	|Open_Baker|