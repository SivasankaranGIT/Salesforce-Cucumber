#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: MHHE Sales Rep and Marketing user is able to create a new Pilot request

Background: 
	Given I am logged into salesforce for "MHHEUserCreatesPilotRequest" 	
	
@OpportunitiesNonDependent
@MHHEUserCreatesPilotRequest @GCRM-8974
Scenario Outline: MHHE Sales Rep and Marketing user is able to create a new Pilot request

	Given Runmode for "MHHEUserCreatesPilotRequest" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When I click sales Ref user details to navigate Marketing
	Then I create a new MHHE Pilot Request

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|