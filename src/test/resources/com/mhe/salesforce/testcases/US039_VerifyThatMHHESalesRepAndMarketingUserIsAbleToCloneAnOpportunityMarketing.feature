#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHHESalesRepAndMarketingUserIsAbleToCloneAnOpportunityMarketing

Background: 
	Given I am logged into salesforce for "MHHECloneOppMark" 	
	
@OpportunitiesNonDependent
@US_TS01_TC10_VerifyThatMHHESalesRepAndMarketingUserIsAbleToCloneAnOpportunityMarketing @GCRM-8977
Scenario Outline: VerifyThatMHHESalesRepAndMarketingUserIsAbleToCloneAnOpportunityMarketing

	Given Runmode for "MHHECloneOppMark" is Y
#	Then I login as Marketing Sales Rep
	Then I do login as "<MHHE_Marketing>"
	When User to search and do Opportunity related validation
	Then global search for opportunities
	And I Clone from opportunity page Marketing
	
	Examples: 
	|MHHE_Marketing|
	|Kara_Allara|