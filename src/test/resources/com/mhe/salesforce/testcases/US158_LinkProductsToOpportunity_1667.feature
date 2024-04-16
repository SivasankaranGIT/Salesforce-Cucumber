#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Marketing user can link targeted products to an opportunity

Background: 
	Given I am logged into salesforce for "LinkProductsToOpportunity" 
	
@OpportunitiesNonDependent
@LinkProductsToOpportunity	@GCRM-9085
Scenario Outline: Marketing user can link targeted products to an opportunity

	Given Runmode for "LinkProductsToOpportunity" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Marketing>"
	When I click on the "opportunitiesTab"
	Then global search for opportunities
	When I navigate to products screen and add a product 
#	And Verify product list within the opportunity

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|

