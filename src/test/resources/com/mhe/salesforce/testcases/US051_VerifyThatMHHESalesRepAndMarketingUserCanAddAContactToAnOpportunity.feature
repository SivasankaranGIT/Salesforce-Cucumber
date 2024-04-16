#STAND_ALONE_SCRIPT - This script can be executed separately.
Feature: VerifyThatMHHESalesRepAndMarketingUserCanAddAContactToAnOpportunity

Background: 
	Given I am logged into salesforce for "MHHERepAddContactOpp"	
	
@OpportunitiesNonDependent
@US_TS01_TC16_VerifyThatMHHESalesRepAndMarketingUserCanAddAContactToAnOpportunity
@GCRM-8972 @GCRM-16011
@RegressionTest @RegressionTestOpportunities
Scenario Outline: VerifyThatMHHESalesRepAndMarketingUserCanAddAContactToAnOpportunity

	Given Runmode for "MHHERepAddContactOpp" is Y
#	Then I login as Marketing Sales Rep
	Then I do login as "<MHHE_Sales_Representative>"
	When User to search and do Opportunity related validation
	And I Add Edit contact from opportunity page

	Examples:
	|MHHE_Sales_Representative|
	|Haley_Loebig|