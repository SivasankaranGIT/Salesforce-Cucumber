#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHE User View marketing documents in product catalog

Background: 
	Given I am logged into salesforce for "MHHEUserViewMarketingDocuments" 
	
@Products
@SmokeTest
@MHHEUserViewMarketingDocuments @GCRM-8989
Scenario Outline:  MHHE User View marketing documents in product catalog

	Given Runmode for "MHHEUserViewMarketingDocuments" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	When I click on the "productCatalogTab"
	When I search product via Area
	Then Verify documents present under all categories

	Examples:
	|MHHE_Business_Administrator|
	|Jaime_Klar|