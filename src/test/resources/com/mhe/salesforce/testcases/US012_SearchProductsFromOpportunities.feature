#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that the SFDC User can search and select products from Opportunities

Background: 
	Given I am logged into salesforce for "SearchProductsFromOpportunities" 
	
@Products
@SearchProductsFromOpportunities	@GCRM-9280
Scenario Outline: Verify that the SFDC User can search and select products from Opportunities

	Given Runmode for "SearchProductsFromOpportunities" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Business_Administrator>"
	Then global search for opportunities
	When I navigate to products screen and add product 
	And Verify product list within the opportunity

	Examples:
  |MHHE_Business_Administrator|
  |Jaime_Klar|