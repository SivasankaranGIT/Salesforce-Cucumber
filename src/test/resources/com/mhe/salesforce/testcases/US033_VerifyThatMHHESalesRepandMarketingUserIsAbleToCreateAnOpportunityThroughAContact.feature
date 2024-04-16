#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHHESalesRepandMarketingUserIsAbleToCreateAnOpportunityThroughAContact

Background: 
	Given I am logged into salesforce for "MHHECreateOppCont"	
	
@OpportunitiesNonDependent
@US_TS01_TC02_VerifyThatMHHESalesRepandMarketingUserIsAbleToCreateAnOpportunityThroughAContact @GCRM-8984
Scenario Outline: VerifyThatMHHESalesRepandMarketingUserIsAbleToCreateAnOpportunityThroughAContact

	Given Runmode for "MHHECreateOppCont" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	And I change the app launcher to MHHE
	When New I click sales Ref user Contacts MHHE
	When I get the Account Name
	And I fill in all the mandatory details to create a new opportunity from Contacts

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|