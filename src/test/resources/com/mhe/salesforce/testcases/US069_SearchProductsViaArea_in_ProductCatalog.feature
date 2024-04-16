#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHE Business admin search products via Area in product catalog

Background: 
	Given I am logged into salesforce for "MHHEBusinessAdminSearchProductViaArea" 
	
@ProductCatalog
@SmokeTest	
@MHHEBusinessAdminSearchProductViaArea @GCRM-9003
Scenario Outline: MHHE Business admin search products via Area in product catalog

	Given Runmode for "MHHEBusinessAdminSearchProductViaArea" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	When Navigate to Product Catalog page
	When I search product via Area
	Then Verify Product course related list is dispalyed

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|