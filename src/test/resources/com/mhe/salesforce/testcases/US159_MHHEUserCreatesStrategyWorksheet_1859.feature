#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that MHHE Sales Rep and Marketing user is able to create a strategy worksheet

Background: 
	Given I am logged into salesforce for "MHHEUserCreatesStrategyWorksheet" 	

@OpportunitiesNonDependent @MHHEUserCreatesStrategyWorksheet @GCRM-8982 @GCRM-25428
Scenario Outline: Verify that MHHE Sales Rep and Marketing user is able to create a strategy worksheet

	Given Runmode for "MHHEUserCreatesStrategyWorksheet" is Y
	Then I do login as "<MHHE_Sales_Representative>"
	And I change the app launcher to MHHE
	Then create a strategy worksheet

Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|