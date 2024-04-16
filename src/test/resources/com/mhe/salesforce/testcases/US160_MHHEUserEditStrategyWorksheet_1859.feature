#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that MHHE Sales Rep and Marketing user is able to edit an existing strategy worksheet

Background: 
	Given I am logged into salesforce for "MHHEUserEditStrategyWorksheet" 	
	
@OpportunitiesNonDependent
@MHHEUserEditStrategyWorksheet @GCRM-8981
Scenario Outline: Verify that MHHE Sales Rep and Marketing user is able to edit an existing strategy worksheet

	Given Runmode for "MHHEUserEditStrategyWorksheet" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
#	When I click sales Ref user details to navigate Marketing
#	When I navigate to the first opp in the page
	Then edit a strategy worksheet

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|