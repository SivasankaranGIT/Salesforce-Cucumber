#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHE Business admin search products via Discipline in product catalog

Background: 
	Given I am logged into salesforce for "SearchProdViaDiscipline" 
	
	
@ProductCatalog
@MHHEBusinessAdminSearchProductViaDiscipline @GCRM-9002
Scenario Outline: MHHE Business admin search products via Course in product catalog

	Given Runmode for "SearchProdViaDiscipline" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	When Navigate to Product Catalog page
	When Search product via Discipline
	Then Verify Product course related list is dispalyed

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|