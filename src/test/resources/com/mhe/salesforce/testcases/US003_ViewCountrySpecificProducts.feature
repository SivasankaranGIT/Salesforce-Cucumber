#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the User is able to can view country-specific product attributes

Background: 
	Given I am logged into salesforce for "ViewCountrySpecificProductsUS" 
	
@Products
@SmokeTest
@ViewCountrySpecificProductsUS @GCRM-9288
Scenario Outline: Verify that the User is able to can view country-specific product attributes

	Given Runmode for "ViewCountrySpecificProductsUS" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When Navigate to products screen
	Then global search for product
	Then Verify fields have read only access

	Examples:
	|MHHE_Sales_Representative|
	|Jackie_Alvarado|