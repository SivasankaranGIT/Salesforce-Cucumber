#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHE Business admin search products via Course in product catalog artemis

Background: 
	Given I am logged into salesforce for "SearchProdViaCourseUS" 
	
	
@ProductCatalog
@MHHEBusinessAdminSearchProductsViaCourseArtemis @GCRM-9289
Scenario Outline: MHHE Business admin search products via Course in product catalog artemis

	Given Runmode for "SearchProdViaCourseUS" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	When I navigate to product catalog tab from menu bar
	When I search document via Course
	Then Verify Product course related list is dispalyed
	Then Verify documents for four categories

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|