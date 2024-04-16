#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHE Business admin search products via ISBN in product catalog

Background: 
	Given I am logged into salesforce for "MHHEBusinessAdminSearchProductViaISBN" 
	
@ProductCatalog
@SmokeTest	
@MHHEBusinessAdminSearchProductViaISBN @GCRM-9291
Scenario Outline: MHHE Business admin search products via ISBN in product catalog

	Given Runmode for "MHHEBusinessAdminSearchProductViaISBN" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	When Navigate to Product Catalog page
	When I search product via ISBN
	Then Verify products related to ISBN are displayed

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|