#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHE Business admin search products via Business Unit in product catalog

Background: 
	Given I am logged into salesforce for "SearchProdViaBusiUnitUS" 
	
	
@ProductCatalog
@MHHEBusinessAdminSearchProductViaBusinessUnit @GCRM-9004
Scenario Outline: MHHE Business admin search products via Area in product catalog

	Given Runmode for "SearchProdViaBusiUnitUS" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	When Navigate to Product Catalog page
	When I search product via Area
	Then Verify Product course related list is dispalyed

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|