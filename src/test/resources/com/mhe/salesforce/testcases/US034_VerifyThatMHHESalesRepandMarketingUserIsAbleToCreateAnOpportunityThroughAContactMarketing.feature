#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHHESalesRepandMarketingUserIsAbleToCreateAnOpportunityThroughAContactMarketing

Background: 
	Given I am logged into salesforce for "MHHECreateOppContMark"	
	
@OpportunitiesNonDependent
@US_TS01_TC02_VerifyThatMHHESalesRepandMarketingUserIsAbleToCreateAnOpportunityThroughAContactMarketing @GCRM-8984
Scenario Outline: VerifyThatMHHESalesRepandMarketingUserIsAbleToCreateAnOpportunityThroughAContactMarketing

	Given Runmode for "MHHECreateOppContMark" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Marketing>"
	And I change the app launcher to MHHE
	Then global search for accounts
	And Mandatory details to create a new opportunity from Contacts Marketing

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|