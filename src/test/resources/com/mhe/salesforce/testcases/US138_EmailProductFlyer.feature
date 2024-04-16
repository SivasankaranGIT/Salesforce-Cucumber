#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature:  Verify that the MHHE User can email a product flyer from a product

Background: 
	Given I am logged into salesforce for "EmailProductFlyer" 
	
	
@ProductCatalog
@EmailProductFlyer @GCRM-8990
Scenario Outline: Verify that the MHHE User can email a product flyer from a product

	Given Runmode for "EmailProductFlyer" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	When I click on the "productCatalogTab"
	Then I search product through business unit
	And Email a product Flyer

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|