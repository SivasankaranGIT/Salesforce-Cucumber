#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the SFDC User can view country-specific attributes on each product

Background: 
	Given I am logged into salesforce for "ViewCountrySpAttrProdUS" 
	
@Products
@SmokeTest
@ViewCountrySpecificAttributesProductsUS @GCRM-9279
Scenario Outline: Verify that the SFDC User can view country-specific attributes on each product

	Given Runmode for "ViewCountrySpAttrProdUS" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for product
	And Verify Country specific attributes

	Examples:
	|MHHE_Sales_Representative|
	|Jackie_Alvarado|