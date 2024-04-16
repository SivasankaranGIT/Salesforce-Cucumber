#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHE Business admin search products via Course in product catalog

Background: 
	Given I am logged into salesforce for "SearchProdViaCourse" 
	
@ProductCatalog
@SmokeTest
@MHHEBusinessAdminSearchProductViaCourse @GCRM-9088
Scenario Outline: MHHE Business admin search products via Course in product catalog

	Given Runmode for "SearchProdViaCourse" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	When Navigate to Product Catalog page
	When I search product via Course
	Then Verify Product course related list is dispalyed

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|