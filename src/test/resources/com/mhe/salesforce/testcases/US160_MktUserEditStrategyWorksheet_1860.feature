#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: Verify that Marketing user is able to edit an existing strategy worksheet

Background: 
	Given I am logged into salesforce for "MktUserEditStrategyWorksheet" 	
	
@OpportunitiesNonDependent
@MktUserEditStrategyWorksheet @GCRM-8981 @GCRM-9173
Scenario Outline: Verify that Marketing user is able to edit an existing strategy worksheet

	Given Runmode for "MktUserEditStrategyWorksheet" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Marketing>"
	When I click sales Ref user details to navigate Marketing
	Then edit a strategy worksheet for marketing user

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|