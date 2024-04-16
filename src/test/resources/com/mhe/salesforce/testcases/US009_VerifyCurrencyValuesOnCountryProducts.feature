#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the currency values on country-product records will be based on the country's pricing

Background: 
	Given I am logged into salesforce for "VerifyCurrencyValuesOnCountryProducts" 
	
	
@Products
@VerifyCurrencyValuesOnCountryProducts	@GCRM-9288
Scenario Outline: Verify that the currency values on country-product records will be based on the country's pricing

	Given Runmode for "VerifyCurrencyValuesOnCountryProducts" is Y
#	Then I login as Sales Rep
	Then I do login as "<System_Administrator>"
	Then I navigate to Sales Home page
	Then Click on CP US product and check currency

	Examples:
	|System_Administrator|
	|Sivasankaran_Periyasamy|