#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHE Business admin search documents via ISBN in product catalog

Background: 
	Given I am logged into salesforce for "MHHEBusinessAdminSearchDocumentViaISBN" 
	
@ProductCatalog
@SmokeTest	
@MHHEBusinessAdminSearchDocumentViaISBN @GCRM-9089
Scenario Outline: MHHE Business admin search documents via ISBN in product catalog

	Given Runmode for "MHHEBusinessAdminSearchDocumentViaISBN" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	When Navigate to Product Catalog page
	When I search product via ISBN
	Then Verify documents present under all categories
	Then I logout of any user
	
	Examples: 
	|MHHE_Business_Administrator|
	|Jaime_Klar|