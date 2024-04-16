#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify the Discipline Flyer on the Product Catalog page

Background: 
	Given I am logged into salesforce for "VerifyDisciplineFlyerProductCatalog" 
	
@ProductCatalog
@SmokeTest
@VerifyDisciplineFlyerProductCatalog @GCRM-8998
Scenario Outline: Verify the Discipline Flyer on the Product Catalog page

	Given Runmode for "VerifyDisciplineFlyerProductCatalog" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	When I click on the "productCatalogTab"
	Then Verify Discipline Flyer in Product Catalog

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|