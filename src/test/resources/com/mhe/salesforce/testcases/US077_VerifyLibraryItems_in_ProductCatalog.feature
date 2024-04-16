#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the List of the Library items available in the Product Catalog

Background: 
	Given I am logged into salesforce for "MHHEBusinessAdminVerifyLibraryItems" 
	
	
@ProductCatalog
@MHHEBusinessAdminVerifyLibraryItems @GCRM-8999
Scenario Outline: Verify the List of the Library items available in the Product Catalog

	Given Runmode for "MHHEBusinessAdminVerifyLibraryItems" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	When I navigate to product catalog tab from menu bar
	Then Verify Library Items

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|