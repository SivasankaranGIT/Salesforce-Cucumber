#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHHESalesRepAndMarketingUserIsAbleToCreateAnOpportunityThroughAnAccount

Background: 
	Given I am logged into salesforce for "MHHECreateOppAcct" 
	
@OpportunitiesNonDependent
@SmokeTest	
@US_TS01_TC01_VerifyThatMHHESalesRepAndMarketingUserIsAbleToCreateAnOpportunityThroughAnAccount @GCRM-9084
Scenario Outline: VerifyThatMHHESalesRepAndMarketingUserIsAbleToCreateAnOpportunityThroughAnAccount

	Given Runmode for "MHHECreateOppAcct" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Marketing>"
	And I change the app launcher to MHHE
	When I click sales Ref user Accounts Marketing
	And I fill in all the mandatory details to create a new opportunity for Marketing User

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|
