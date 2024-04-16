#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature:  Verify that I can build Product views and select products from various access points.

Background: 
	Given I am logged into salesforce for "BuildProductViews" 
	
	
@Products
@BuildProductViews @GCRM-9222
Scenario Outline: Verify that I can build Product views and select products from various access points.

	Given Runmode for "BuildProductViews" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When Navigate to products screen
	And Create a product view
	And Verify products list
	Then Delete product view
	
	Examples: 
	|MHHE_Sales_Representative|
	|Jackie_Alvarado|