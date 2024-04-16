#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHHESalesRepAndMarketingUserCaneditTheContactDetailsTiedToAnOpportunity

Background: 
	Given I am logged into salesforce for "MHHEEditContactTiedToOpp"	
	
@OpportunitiesNonDependent
@US_TS01_TC17_VerifyThatMHHESalesRepAndMarketingUserCaneditTheContactDetailsTiedToAnOpportunity @GCRM-8971
Scenario Outline: VerifyThatMHHESalesRepAndMarketingUserCaneditTheContactDetailsTiedToAnOpportunity

	Given Runmode for "MHHEEditContactTiedToOpp" is Y
#	Then I login as Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for opportunities
	And Edit contact of Opportunities
	
	Examples: 
	|MHHE_Sales_Representative|
	|Haley_Loebig|