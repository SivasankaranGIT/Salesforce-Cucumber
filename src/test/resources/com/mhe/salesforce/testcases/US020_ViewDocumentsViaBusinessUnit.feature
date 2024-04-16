#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: SFDC User search the Documents via the Business Unit in the Product Catalog

Background: 
	Given I am logged into salesforce for "ViewDocumentsViaBusinessUnit" 
	
	
@ProductCatalog
@ViewDocumentsViaBusinessUnit @GCRM-9290
Scenario Outline:  SFDC User search the Documents via the Business Unit in the Product Catalog

	Given Runmode for "ViewDocumentsViaBusinessUnit" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	When I click on the "productCatalogTab"
	When I search product via Area
	Then Verify documents present under all categories

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|