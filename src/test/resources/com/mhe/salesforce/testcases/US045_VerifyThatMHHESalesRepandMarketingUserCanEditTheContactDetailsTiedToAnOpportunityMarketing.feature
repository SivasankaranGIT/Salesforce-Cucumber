#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHHESalesRepandMarketingUserCanEditTheContactDetailsTiedToAnOpportunityMarketing

Background: 
	Given I am logged into salesforce for "MHHEEditContactTiedToOppMark"	
	
@OpportunitiesNonDependent
@US_TS01_TC17_VerifyThatMHHESalesRepandMarketingUserCanEditTheContactDetailsTiedToAnOpportunityMarketing @GCRM-8971
Scenario Outline: VerifyThatMHHESalesRepandMarketingUserCanEditTheContactDetailsTiedToAnOpportunityMarketing

	Given Runmode for "MHHEEditContactTiedToOppMark" is Y
#	Then I login as Marketing Sales Rep
	Then I do login as "<MHHE_Marketing>"
  Then global search for opportunities
	And Edit contact of Opportunities Marketing

	Examples:
	|MHHE_Marketing|
	|Kara_Allara|