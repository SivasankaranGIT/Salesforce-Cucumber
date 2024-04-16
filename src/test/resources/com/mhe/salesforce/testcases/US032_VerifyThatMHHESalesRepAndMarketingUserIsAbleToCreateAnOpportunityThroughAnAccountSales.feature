#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHHESalesRepAndMarketingUserIsAbleToCreateAnOpportunityThroughAnAccountSales

Background: 
	Given I am logged into salesforce for "MHHEcreateOppAcctSales" 
	
@OpportunitiesNonDependent
@SmokeTest
@US_TS01_TC01_VerifyThatMHHESalesRepAndMarketingUserIsAbleToCreateAnOpportunityThroughAnAccountSales @GCRM-9084
Scenario Outline: VerifyThatMHHESalesRepAndMarketingUserIsAbleToCreateAnOpportunityThroughAnAccountSales

	Given Runmode for "MHHEcreateOppAcctSales" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHEcreateOppAcctSales>"
	Then global search for accounts
	And I fill in all the mandatory details to create a new opportunity Sales

	Examples:
	|MHHEcreateOppAcctSales|
	|Kara_Allara|