#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHHESalesRepandMarketingUserCanEditTheContactDetailsTiedToAnOpportunityMarketing

Background: 
	Given I am logged into salesforce for "MHESEditContactTiedOpp"	
	
@OpportunitiesNonDependent
@US_TS01_TC34_VerifyThatMHESUserIsAbleToEditAContactTiedToAnOpportunity @GCRM-8961
Scenario Outline: VerifyThatMHESUserIsAbleToEditAContactTiedToAnOpportunity

	Given Runmode for "MHESEditContactTiedOpp" is Y
#	Then I login as Marketing Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	Then global search for opportunities
	And Edit contact of Opportunities MHES

	Examples:
	|MHHE_Sales_Representative|
	|Danielle_Snyder|