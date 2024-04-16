#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that Marketing user is able to create a strategy worksheet

Background: 
	Given I am logged into salesforce for "MktUserCreatesStrategyWorksheet" 	
	
@OpportunitiesNonDependent
@MktUserCreatesStrategyWorksheet @GCRM-8982
Scenario Outline: Verify that Marketing user is able to create a strategy worksheet

	Given Runmode for "MktUserCreatesStrategyWorksheet" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Marketing>"
	When I click sales Ref user details to navigate Marketing
	Then create a strategy worksheet for marketing user
	
	Examples: 
	|MHHE_Marketing|
	|Kara_Allara|