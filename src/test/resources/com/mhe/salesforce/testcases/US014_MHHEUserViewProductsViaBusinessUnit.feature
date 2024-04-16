#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHE User View product information via business unit in product catalog

Background: 
	Given I am logged into salesforce for "MHHEUserViewProductsViaBusinessUnit" 
	
@ProductCatalog
@SmokeTest
@MHHEUserViewProductsViaBusinessUnit @GCRM-9288
Scenario Outline:  MHHE User View product information via business unit in product catalog

	Given Runmode for "MHHEUserViewProductsViaBusinessUnit" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	When I navigate to product catalog tab from menu bar
	When I search product via Area
	Then Verify Product course related list is dispalyed

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|
