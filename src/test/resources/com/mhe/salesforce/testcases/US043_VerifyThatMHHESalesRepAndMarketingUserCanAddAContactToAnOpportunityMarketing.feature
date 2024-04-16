#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHHESalesRepAndMarketingUserCanAddAContactToAnOpportunityMarketing

Background: 
	Given I am logged into salesforce for "MHHEAddContactToOppMark" 	
	
@OpportunitiesNonDependent
@US_TS01_TC16_VerifyThatMHHESalesRepAndMarketingUserCanAddAContactToAnOpportunityMarketing @GCRM-8972 @GCRM-16011
Scenario Outline: VerifyThatMHHESalesRepAndMarketingUserCanAddAContactToAnOpportunityMarketing

	Given Runmode for "MHHEAddContactToOppMark" is Y
#	Then I login as Marketing Sales Rep
	Then I do login as "<MHHE_Marketing>"
	And I change the app launcher to MHHE
	When User to search and do Opportunity related validation
	And I Add Edit contact from opportunity page marketing

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|